package com.lasha.dice.game.exception;

public class UserAlreadyExistsException extends RuntimeException
{
    private static final String DEFAULT_MESSAGE = "user already exists";

    public UserAlreadyExistsException()
    {
        super(DEFAULT_MESSAGE);
    }
}
