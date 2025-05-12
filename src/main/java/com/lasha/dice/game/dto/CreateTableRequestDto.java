package com.lasha.dice.game.dto;

public class CreateTableRequestDto
{
    private String hostId;

    public CreateTableRequestDto()
    {
    }

    public CreateTableRequestDto(String hostId)
    {
        this.hostId = hostId;
    }

    public String getHostId()
    {
        return hostId;
    }

    public void setHostId(String hostId)
    {
        this.hostId = hostId;
    }

    @Override
    public String toString()
    {
        return "CreateTableRequestDto{" +
                "hostId=" + hostId +
                '}';
    }
}
