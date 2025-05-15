package com.lasha.dice.game.dto.user;

public class LoginUserRequestDto
{
    private String username;
    private String password;

    public LoginUserRequestDto()
    {
    }

    public LoginUserRequestDto(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isValid()
    {
        return username != null && !username.isEmpty() &&
                password != null && !password.isEmpty();
    }

    @Override
    public String toString()
    {
        return "LoginUserRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
