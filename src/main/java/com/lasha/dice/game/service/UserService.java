package com.lasha.dice.game.service;

import com.lasha.dice.game.dto.*;
import com.lasha.dice.game.entity.UserEntity;
import com.lasha.dice.game.exception.InvalidUserValuesException;
import com.lasha.dice.game.exception.UserAlreadyExistsException;
import com.lasha.dice.game.exception.UserNotFoundException;
import com.lasha.dice.game.exception.UsersNotAvailableException;
import com.lasha.dice.game.repository.UserRepository;
import com.lasha.dice.game.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

        UserLoginRequestDto loginDto = new UserLoginRequestDto();
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

    public JwtResponseDto login(UserLoginRequestDto loginDto)
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

    public UserDeleteResponseDto deleteUser(UserDeleteRequestDto userDeleteRequestDto)
    {
        if(userDeleteRequestDto == null || userDeleteRequestDto.getUsername() == null || userDeleteRequestDto.getUsername().isEmpty())
        {
            throw new InvalidUserValuesException();
        }

        UserEntity userEntity = userRepository.findByUsername(userDeleteRequestDto.getUsername()).orElseThrow(() -> new UserNotFoundException());

        userRepository.delete(userEntity);

        return userMapper.userEntityToUserDeleteResponseDto(userEntity);
    }
}
