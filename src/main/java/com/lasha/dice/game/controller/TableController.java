package com.lasha.dice.game.controller;

import com.lasha.dice.game.dto.CreateTableRequestDto;
import com.lasha.dice.game.entity.UserEntity;
import com.lasha.dice.game.enums.Enums;
import com.lasha.dice.game.repository.UserRepository;
import com.lasha.dice.game.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/table")
public class TableController
{
    private final TableService tableService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public TableController(TableService tableService)
    {
        this.tableService = tableService;
    }

    @PostMapping("/create")
    public void createTable()
    {
        System.out.println("create table entered");
        UserEntity userEntity = userRepository.findByUsername("lasha").orElseThrow(() -> new RuntimeException("User not found"));
        UserEntity userEntityTwo = userRepository.findByUsername("natia").orElseThrow(() -> new RuntimeException("User not found"));
        CreateTableRequestDto createTableRequestDto = new CreateTableRequestDto(new UUID(5, 5), new UUID(6, 6), new UUID(7, 7), Enums.TableStatus.AVAILABLE);
        tableService.createTable(createTableRequestDto);
    }
}
