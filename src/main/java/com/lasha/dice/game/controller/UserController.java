package com.lasha.dice.game.controller;

import com.lasha.dice.game.dto.*;
import com.lasha.dice.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponseDto> register(@RequestBody CreateUserRequestDto userCreationDto) {
        return new ResponseEntity<>(userService.saveUserAndGenerateToken(userCreationDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserDeleteResponseDto> deleteUser(@RequestBody UserDeleteRequestDto userDeleteRequestDto)
    {
        return new ResponseEntity<UserDeleteResponseDto>(userService.deleteUser(userDeleteRequestDto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        return new ResponseEntity<List<UserDto>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username)
    {
        return new ResponseEntity<UserDto>(userService.findByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody UserLoginRequestDto userLoginDto)
    {
        return new ResponseEntity<>(userService.login(userLoginDto), HttpStatus.OK);
    }
}
