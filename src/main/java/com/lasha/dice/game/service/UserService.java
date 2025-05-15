package com.lasha.dice.game.service;

import com.lasha.dice.game.dto.user.*;
import com.lasha.dice.game.entity.UserEntity;
import com.lasha.dice.game.exception.exceptions.InvalidUserValuesException;
import com.lasha.dice.game.exception.exceptions.UserAlreadyExistsException;
import com.lasha.dice.game.exception.exceptions.UserNotFoundException;
import com.lasha.dice.game.exception.exceptions.UsersNotAvailableException;
import com.lasha.dice.game.repository.UserRepository;
import com.lasha.dice.game.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder, JwtService jwtService, AuthenticationManager authenticationManager)
    {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public JwtResponseDto saveUserAndGenerateToken(CreateUserRequestDto userCreationDto)
    {
        if (userCreationDto == null || userCreationDto.isValid() == false)
        {
            throw new InvalidUserValuesException();
        }

        if (userRepository.findByUsername(userCreationDto.getUsername()).isPresent() == true)
        {
            throw new UserAlreadyExistsException();
        }

        userCreationDto.setPassword(bCryptPasswordEncoder.encode(userCreationDto.getPassword()));
        UserEntity userEntity = userMapper.userCreationDtoToUserEntity(userCreationDto);
        userRepository.save(userEntity);

        LoginUserRequestDto loginDto = new LoginUserRequestDto();
        loginDto.setUsername(userCreationDto.getUsername());
        loginDto.setPassword(userCreationDto.getPassword()); // this is already encoded, but it doesn't matter for token

        return jwtService.generateToken(loginDto);
    }

    public List<UserDto> getAllUsers()
    {
        List<UserDto> toReturn = userMapper.userEntitiesToUserDto(userRepository.findAll());

        if(toReturn == null || toReturn.isEmpty())
        {
            throw new UsersNotAvailableException();
        }

        return toReturn;
    }

    public UserDto findByUsername(String username)
    {
        if (username == null || username.isEmpty())
        {
            throw new InvalidUserValuesException();
        }

        UserEntity retrievedUser = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException());

        return userMapper.userEntityToUserDto(retrievedUser);
    }

    public JwtResponseDto login(LoginUserRequestDto loginDto)
    {
        if (loginDto == null || loginDto.isValid() == false)
        {
            throw new InvalidUserValuesException();
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(), loginDto.getPassword()
                )
        );

        if (authentication.isAuthenticated() == false)
        {
            throw new InvalidUserValuesException();
        }

        return jwtService.generateToken(loginDto);
    }

    public DeleteUserResponseDto deleteUser(DeleteUserRequestDto deleteUserRequestDto)
    {
        if(deleteUserRequestDto == null || deleteUserRequestDto.getUsername() == null || deleteUserRequestDto.getUsername().isEmpty())
        {
            throw new InvalidUserValuesException();
        }

        UserEntity userEntity = userRepository.findByUsername(deleteUserRequestDto.getUsername()).orElseThrow(() -> new UserNotFoundException());

        userRepository.delete(userEntity);

        return userMapper.userEntityToUserDeleteResponseDto(userEntity);
    }

    public UserDto findUserById(UUID id)
    {
        if (id == null || id.toString().isEmpty())
        {
            throw new InvalidUserValuesException();
        }

        UserEntity retrievedUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());

        return userMapper.userEntityToUserDto(retrievedUser);
    }
}
