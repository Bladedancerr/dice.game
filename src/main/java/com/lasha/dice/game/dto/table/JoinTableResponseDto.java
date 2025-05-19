package com.lasha.dice.game.dto.table;

import java.util.UUID;

public class JoinTableResponseDto
{
    private String okay = "okay";
    private UUID tableId;
    private UUID hostId;

    public JoinTableResponseDto()
    {
    }

    public String getOkay()
    {
        return okay;
    }

    public void setOkay(String okay)
    {
        this.okay = okay;
    }

    public UUID getTableId()
    {
        return tableId;
    }

    public void setTableId(UUID tableId)
    {
        this.tableId = tableId;
    }

    public UUID getHostId()
    {
        return hostId;
    }

    public void setHostId(UUID hostId)
    {
        this.hostId = hostId;
    }
}
