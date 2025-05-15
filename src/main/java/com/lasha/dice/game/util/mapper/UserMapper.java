package com.lasha.dice.game.util.mapper;

import com.lasha.dice.game.dto.user.CreateUserRequestDto;
import com.lasha.dice.game.dto.user.DeleteUserResponseDto;
import com.lasha.dice.game.dto.user.UserDto;
import com.lasha.dice.game.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
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

        UserDto userDto = new UserDto();
        userDto.setUsername(userEntity.getUsername());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPhoneNumber(userEntity.getPhoneNumber());
        userDto.setId(userEntity.getId());
        userDto.setWinStreak(userEntity.getWinStreak());
        userDto.setAvatarId(userEntity.getAvatarId());
        userDto.setGamesPlayed(userEntity.getGamesPlayed());
        return userDto;
    }

    public UserEntity userCreationDtoToUserEntity(CreateUserRequestDto userCreationDto)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userCreationDto.getUsername());
        userEntity.setPassword(userCreationDto.getPassword());
        userEntity.setEmail(userCreationDto.getEmail());
        userEntity.setPhoneNumber(userCreationDto.getPhoneNumber());
        userEntity.setCreatedAt(new Date(System.currentTimeMillis()));
        return userEntity;
    }

    public DeleteUserResponseDto userEntityToUserDeleteResponseDto(UserEntity userEntity)
    {
        if(userEntity == null)
        {
            return null;
        }

        return new DeleteUserResponseDto(userEntity.getUsername(), new Date(System.currentTimeMillis()));
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
