package com.lasha.dice.game.exception.exceptions;

public class UserNotFoundException extends RuntimeException
{
    private static final String DEFAULT_MESSAGE = "user not found";

    public UserNotFoundException()
    {
        super(DEFAULT_MESSAGE);
    }

    public UserNotFoundException(String message)
    {
        super(message);
    }
}
