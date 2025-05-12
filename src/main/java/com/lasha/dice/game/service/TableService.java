package com.lasha.dice.game.service;

import com.lasha.dice.game.dto.CreateTableRequestDto;
import com.lasha.dice.game.entity.TableEntity;
import com.lasha.dice.game.repository.TableRepository;
import com.lasha.dice.game.util.mapper.TableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService
{
    private final TableRepository tableRepository;
    private final TableMapper tableMapper;

    @Autowired
    public TableService (TableRepository tableRepository, TableMapper tableMapper)
    {
        this.tableRepository = tableRepository;
        this.tableMapper = tableMapper;
    }

    public void createTable(CreateTableRequestDto createTableRequestDto)
    {
        TableEntity tableEntity = tableMapper.tableCreationDtoToTableEntity(createTableRequestDto, null, null);
        tableRepository.save(tableEntity);
    }
}
