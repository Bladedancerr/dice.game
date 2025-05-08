package com.lasha.dice.game.controller;

import com.lasha.dice.game.dto.UserCreationDto;
import com.lasha.dice.game.dto.UserDto;
import com.lasha.dice.game.dto.UserLoginDto;
import com.lasha.dice.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<UserDto> register(@RequestBody UserCreationDto userCreationDto)
    {
        return new ResponseEntity<UserDto>(userService.saveUser(userCreationDto), HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        return new ResponseEntity<List<UserDto>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username)
    {
        return new ResponseEntity<UserDto>(userService.findByUsername(username), HttpStatus.OK);
    }
}
