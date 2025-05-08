package com.lasha.dice.game.exception;

public class UserNotFoundException extends RuntimeException
{
    private static final String DEFAULT_MESSAGE = "user not found";

    public UserNotFoundException()
    {
        super(DEFAULT_MESSAGE);
    }
}
