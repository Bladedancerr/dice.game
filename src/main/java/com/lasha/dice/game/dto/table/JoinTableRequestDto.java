package com.lasha.dice.game.dto.table;

import java.util.UUID;

public class JoinTableRequestDto
{
    private UUID guestId;
    private UUID tableId;

    public JoinTableRequestDto()
    {
    }

    public UUID getGuestId()
    {
        return guestId;
    }

    public void setGuestId(UUID guestId)
    {
        this.guestId = guestId;
    }

    public UUID getTableId()
    {
        return tableId;
    }

    public void setTableId(UUID tableId)
    {
        this.tableId = tableId;
    }

    @Override
    public String toString()
    {
        return "JoinTableRequestDto{" +
                "guestId=" + guestId +
                ", tableId=" + tableId +
                '}';
    }
}
