package com.lasha.dice.game.util.mapper;

import com.lasha.dice.game.dto.UserDto;
import com.lasha.dice.game.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper
{
    public UserDto toUserDto(UserEntity userEntity)
    {
        UserDto toReturn = new UserDto();

        return toReturn;
    }
}
