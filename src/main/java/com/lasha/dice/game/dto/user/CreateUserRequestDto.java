package com.lasha.dice.game.dto.user;

import java.util.regex.Pattern;

public class CreateUserRequestDto
{
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    public CreateUserRequestDto()
    {
    }

    public CreateUserRequestDto(String username, String password, String email, String phoneNumber)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValid()
    {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);

        return username != null && !username.isEmpty() &&
                password != null && !password.isEmpty() &&
                email != null && !email.isEmpty() &&
                pattern.matcher(email).matches() && phoneNumber != null &&
                !phoneNumber.isEmpty();
    }
}
