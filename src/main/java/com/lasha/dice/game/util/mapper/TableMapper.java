package com.lasha.dice.game.util.mapper;

import com.lasha.dice.game.dto.CreateTableRequestDto;
import com.lasha.dice.game.entity.TableEntity;
import com.lasha.dice.game.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class TableMapper
{
    public TableEntity tableCreationDtoToTableEntity(CreateTableRequestDto createTableRequestDto, UserEntity host, UserEntity guest)
    {
        TableEntity tableEntity = new TableEntity(createTableRequestDto.getId(), host, guest, createTableRequestDto.getStatus());
        return tableEntity;
    }
}
