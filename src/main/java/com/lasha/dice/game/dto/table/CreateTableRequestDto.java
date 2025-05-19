package com.lasha.dice.game.dto.table;

import java.util.UUID;

public class CreateTableRequestDto
{
    private UUID hostId;

    public CreateTableRequestDto()
    {
    }

    public CreateTableRequestDto(UUID hostId)
    {
        this.hostId = hostId;
    }

    public UUID getHostId()
    {
        return hostId;
    }

    public void setHostId(UUID hostId)
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
