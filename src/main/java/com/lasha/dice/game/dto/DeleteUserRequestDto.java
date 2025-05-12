package com.lasha.dice.game.dto;

public class DeleteUserRequestDto
{
    private String username;
    private String reasonOfDeletion;

    public DeleteUserRequestDto()
    {
    }

    public DeleteUserRequestDto(String username, String reasonOfDeletion)
    {
        this.username = username;
        this.reasonOfDeletion = reasonOfDeletion;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getReasonOfDeletion()
    {
        return reasonOfDeletion;
    }

    public void setReasonOfDeletion(String reasonOfDeletion)
    {
        this.reasonOfDeletion = reasonOfDeletion;
    }
}
