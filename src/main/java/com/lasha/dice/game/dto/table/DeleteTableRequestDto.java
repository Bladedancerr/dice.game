package com.lasha.dice.game.dto.table;

import java.util.UUID;

public class DeleteTableRequestDto
{
    private UUID tableId;

    public DeleteTableRequestDto()
    {

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
