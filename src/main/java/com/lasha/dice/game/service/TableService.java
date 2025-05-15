package com.lasha.dice.game.service;

import com.lasha.dice.game.dto.table.*;
import com.lasha.dice.game.entity.TableEntity;
import com.lasha.dice.game.entity.UserEntity;
import com.lasha.dice.game.enums.Enums;
import com.lasha.dice.game.exception.exceptions.TableNotFoundException;
import com.lasha.dice.game.exception.exceptions.UserNotFoundException;
import com.lasha.dice.game.repository.TableRepository;
import com.lasha.dice.game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TableService
{
    private final TableRepository tableRepository;

    private final UserRepository userRepository;

    @Autowired
    public TableService (TableRepository tableRepository, UserRepository userRepository)
    {
        this.tableRepository = tableRepository;
        this.userRepository = userRepository;
    }

    public CreateTableResponseDto saveTable(CreateTableRequestDto createTableRequestDto)
    {
        UUID hostId = UUID.fromString(createTableRequestDto.getHostId());
        UserEntity hostEntity = userRepository.findById(hostId).orElseThrow(() -> new UserNotFoundException());
        TableEntity tableEntity = new TableEntity();
        tableEntity.setHost(hostEntity);
        tableEntity.setHostUsername(hostEntity.getUsername());
        tableEntity.setStatus(Enums.TableStatus.AVAILABLE);
        tableRepository.save(tableEntity);

        return new CreateTableResponseDto();
    }

    public JoinTableResponseDto joinTable(JoinTableRequestDto joinTableRequestDto)
    {
        System.out.println("service " + joinTableRequestDto.toString());

        UserEntity guestEntity = userRepository.findById(joinTableRequestDto.getGuestId()).orElseThrow(() -> new UserNotFoundException());
        TableEntity tableToJoin = tableRepository.findById(joinTableRequestDto.getTableId()).orElseThrow(() -> new TableNotFoundException());
        tableToJoin.setGuest(guestEntity);
        System.out.println("guest entity" + guestEntity.getUsername());
        tableToJoin.setGuestUsername(guestEntity.getUsername());
        tableToJoin.setStatus(Enums.TableStatus.FULL);
        tableRepository.save(tableToJoin);
        return new JoinTableResponseDto();
    }

    public List<TableDto> getAvailableTables(UUID userId)
    {
        List<TableEntity> availableTables = tableRepository.getAvailableTables(userId);

        if(availableTables.isEmpty() == true)
        {
            throw new TableNotFoundException();
        }

        List<TableDto> toReturn = new ArrayList<>();
        TableDto tableDto;

        for(TableEntity table : availableTables)
        {
            tableDto = new TableDto();
            tableDto.setId(table.getId());
            tableDto.setHostId(table.getHost().getId());
            tableDto.setGuestId(table.getGuest() != null ? table.getGuest().getId() : null);
            tableDto.setGuestUsername(table.getGuestUsername());
            tableDto.setHostUsername(table.getHostUsername());
            toReturn.add(tableDto);
        }
        System.out.println(toReturn);
        return toReturn;
    }
}
