package com.lasha.dice.game.dto.table;

import java.util.UUID;

public class TableDto
{
    private UUID id;
    private UUID hostId;
    private UUID guestId;

    private String hostUsername;
    private String guestUsername;

    public TableDto()
    {
    }

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public UUID getHostId()
    {
        return hostId;
    }

    public void setHostId(UUID hostId)
    {
        this.hostId = hostId;
    }

    public UUID getGuestId()
    {
        return guestId;
    }

    public void setGuestId(UUID guestId)
    {
        this.guestId = guestId;
    }

    public String getHostUsername()
    {
        return hostUsername;
    }

    public void setHostUsername(String hostUsername)
    {
        this.hostUsername = hostUsername;
    }

    public String getGuestUsername()
    {
        return guestUsername;
    }

    public void setGuestUsername(String guestUsername)
    {
        this.guestUsername = guestUsername;
    }

    @Override
    public String toString()
    {
        return "TableDto{" +
                "id=" + id +
                ", hostId=" + hostId +
                ", guestId=" + guestId +
                ", hostUsername='" + hostUsername + '\'' +
                ", guestUsername='" + guestUsername + '\'' +
                '}';
    }
}
