package com.lasha.dice.game.service;

import com.lasha.dice.game.dto.UserCreationDto;
import com.lasha.dice.game.dto.UserDto;
import com.lasha.dice.game.dto.UserLoginDto;
import com.lasha.dice.game.entity.UserEntity;
import com.lasha.dice.game.exception.InvalidUserValuesException;
import com.lasha.dice.game.exception.UserAlreadyExistsException;
import com.lasha.dice.game.exception.UserNotFoundException;
import com.lasha.dice.game.exception.UsersNotAvailableException;
import com.lasha.dice.game.repository.UserRepository;
import com.lasha.dice.game.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private UserRepository userRepository;

    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper)
    {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto saveUser(UserCreationDto userCreationDto)
    {
        System.out.println("service " + userCreationDto);

        if(userCreationDto.isValid() == false)
        {
            throw new InvalidUserValuesException();
        }

        UserEntity retrievedUser = userRepository.findByUsername(userCreationDto.getUsername()).orElse(null);

        if (retrievedUser != null)
        {
            throw new UserAlreadyExistsException();
        }

        UserEntity userEntity = userMapper.userCreationDtoToUserEntity(userCreationDto);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.userEntityToUserDto(savedUser);
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

        UserEntity retrievedUser = userRepository.findByUsername(username).orElse(null);

        if (retrievedUser == null)
        {
            throw new UserNotFoundException();
        }

        return userMapper.userEntityToUserDto(retrievedUser);
    }
}
