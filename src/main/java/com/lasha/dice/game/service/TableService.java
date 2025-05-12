package com.lasha.dice.game.service;

import com.lasha.dice.game.dto.CreateTableRequestDto;
import com.lasha.dice.game.dto.JoinTableRequestDto;
import com.lasha.dice.game.entity.TableEntity;
import com.lasha.dice.game.entity.UserEntity;
import com.lasha.dice.game.enums.Enums;
import com.lasha.dice.game.exception.TableNotFoundException;
import com.lasha.dice.game.exception.UserNotFoundException;
import com.lasha.dice.game.repository.TableRepository;
import com.lasha.dice.game.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveTable(CreateTableRequestDto createTableRequestDto)
    {
        UUID hostId = UUID.fromString(createTableRequestDto.getHostId());
        UserEntity hostEntity = userRepository.findById(hostId).orElseThrow(() -> new UserNotFoundException());
        TableEntity tableEntity = new TableEntity();
        tableEntity.setHost(hostEntity);
        tableEntity.setHostUsername(hostEntity.getUsername());
        tableEntity.setStatus(Enums.TableStatus.AVAILABLE);
        tableRepository.save(tableEntity);
    }

    public void joinTable(JoinTableRequestDto joinTableRequestDto)
    {
        UUID guestId = UUID.fromString(joinTableRequestDto.getGuestId());
        UserEntity guestEntity = userRepository.findById(guestId).orElseThrow(() -> new UserNotFoundException());
        TableEntity tableToJoin = tableRepository.findById(UUID.fromString(joinTableRequestDto.getTableId())).orElseThrow(() -> new TableNotFoundException());
        tableToJoin.setGuest(guestEntity);
        tableToJoin.setGuestUsername(guestEntity.getUsername());
        tableToJoin.setStatus(Enums.TableStatus.FULL);
        tableRepository.save(tableToJoin);
    }
}
