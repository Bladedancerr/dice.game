package com.lasha.dice.game.util.mapper;

import com.lasha.dice.game.dto.UserCreationDto;
import com.lasha.dice.game.dto.UserDto;
import com.lasha.dice.game.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper
{
    public UserDto userEntityToUserDto(UserEntity userEntity)
    {
        if(userEntity == null)
        {
            return null;
        }

        return new UserDto(userEntity.getUsername(), userEntity.getEmail(), userEntity.getPhoneNumber());
    }

    public UserEntity userCreationDtoToUserEntity(UserCreationDto userCreationDto)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userCreationDto.getUsername());
        userEntity.setPassword(userCreationDto.getPassword());
        userEntity.setEmail(userCreationDto.getEmail());
        userEntity.setPhoneNumber(userCreationDto.getPhoneNumber());
        return userEntity;
    }

    public List<UserDto> userEntitiesToUserDto(List<UserEntity> userEntities)
    {
        if(userEntities == null || userEntities.isEmpty())
        {
            return null;
        }

        List<UserDto> toReturn = new ArrayList<>();

        for(UserEntity userEntity : userEntities)
        {
            toReturn.add(userEntityToUserDto(userEntity));
        }

        return toReturn;
    }
}
