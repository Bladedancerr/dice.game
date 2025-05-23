package com.lasha.dice.game.dto.table;

import java.util.UUID;

public class CreateTableResponseDto
{
    private String okay = "okay";
    private UUID tableId;

    public CreateTableResponseDto()
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
}
