package com.lasha.dice.game.controller;

import com.lasha.dice.game.dto.table.*;
import com.lasha.dice.game.repository.UserRepository;
import com.lasha.dice.game.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<CreateTableResponseDto> createTable(@RequestBody CreateTableRequestDto createTableRequestDto)
    {
        return new ResponseEntity<>(tableService.saveTable(createTableRequestDto), HttpStatus.CREATED);
    }

    @PostMapping("/join")
    public ResponseEntity<JoinTableResponseDto> JoinTable(@RequestBody JoinTableRequestDto joinTableRequestDto)
    {
        System.out.println("controller " + joinTableRequestDto.toString());
        return new ResponseEntity<>(tableService.joinTable(joinTableRequestDto), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<TableDto>> getAvailableTables(@PathVariable UUID userId)
    {
        return new ResponseEntity<>(tableService.getAvailableTables(userId), HttpStatus.OK);
    }
}
