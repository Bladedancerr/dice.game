package com.lasha.dice.game.exception.exceptions;

public class InvalidUserValuesException extends RuntimeException
{
    private static final String DEFAULT_MESSAGE = "invalid user values";

    public InvalidUserValuesException()
    {
        super(DEFAULT_MESSAGE);
    }

    public InvalidUserValuesException(String message)
    {
        super(message);
    }
}
