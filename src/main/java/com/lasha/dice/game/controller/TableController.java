package com.lasha.dice.game.controller;

import com.lasha.dice.game.dto.CreateTableRequestDto;
import com.lasha.dice.game.dto.JoinTableRequestDto;
import com.lasha.dice.game.entity.UserEntity;
import com.lasha.dice.game.enums.Enums;
import com.lasha.dice.game.repository.UserRepository;
import com.lasha.dice.game.service.TableService;
import com.lasha.dice.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public void createTable(@RequestBody CreateTableRequestDto createTableRequestDto)
    {
        tableService.saveTable(createTableRequestDto);
    }

    @PostMapping("/join")
    public void JoinTable(@RequestBody JoinTableRequestDto joinTableRequestDto)
    {
        System.out.println("joinTableRequestDto = " + joinTableRequestDto);
        tableService.joinTable(joinTableRequestDto);
    }
}
