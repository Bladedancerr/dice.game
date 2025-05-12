package com.lasha.dice.game.dto;

public class JoinTableRequestDto
{
    private String guestId;
    private String tableId;

    public JoinTableRequestDto()
    {
    }

    public JoinTableRequestDto(String tableId, String guestId)
    {
        this.tableId = tableId;
        this.guestId = guestId;
    }

    public String getGuestId()
    {
        return guestId;
    }

    public void setGuestId(String guestId)
    {
        this.guestId = guestId;
    }

    public String getTableId()
    {
        return tableId;
    }

    public void setTableId(String tableId)
    {
        this.tableId = tableId;
    }
}
