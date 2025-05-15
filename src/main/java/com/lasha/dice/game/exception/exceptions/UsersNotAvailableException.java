package com.lasha.dice.game.exception.exceptions;

public class UsersNotAvailableException extends RuntimeException
{
    private static final String DEFAULT_MESSAGE = "users list is empty";

    public UsersNotAvailableException()
    {
        super(DEFAULT_MESSAGE);
    }

    public UsersNotAvailableException(String message)
    {
        super(message);
    }
}
