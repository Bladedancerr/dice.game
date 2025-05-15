package com.lasha.dice.game.exception.exceptions;

public class TableNotFoundException extends  RuntimeException
{
    private static final String DEFAULT_MESSAGE = "table not found";

    public TableNotFoundException()
    {
        super(DEFAULT_MESSAGE);
    }

    public TableNotFoundException(String message)
    {
        super(message);
    }
}
