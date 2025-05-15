package com.lasha.dice.game.dto.user;

public class JwtResponseDto
{
    private String token;
    private UserDto userDto;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public UserDto getUserDto()
    {
        return userDto;
    }

    public void setUserDto(UserDto userDto)
    {
        this.userDto = userDto;
    }
}
