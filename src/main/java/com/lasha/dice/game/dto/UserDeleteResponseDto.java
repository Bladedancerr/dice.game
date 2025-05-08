package com.lasha.dice.game.dto;

import java.util.Date;

public class UserDeleteResponseDto
{
    private String username;
    private int numberOfDaysAfterAccountCreation;

    public UserDeleteResponseDto()
    {
    }

    public UserDeleteResponseDto(String username, Date deleteAt)
    {
        this.username = username;
        numberOfDaysAfterAccountCreation = (int) ((deleteAt.getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24));
    }


    public int getNumberOfDaysAfterAccountCreation()
    {
        return numberOfDaysAfterAccountCreation;
    }

    public void setNumberOfDaysAfterAccountCreation(int numberOfDaysAfterAccountCreation)
    {
        this.numberOfDaysAfterAccountCreation = numberOfDaysAfterAccountCreation;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
