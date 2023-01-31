package com.example.demo1111111111.controller;

import com.example.demo1111111111.dto.UserUpdateDto;
import com.example.demo1111111111.entity.User;
import com.example.demo1111111111.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    @GetMapping("/getuser")
    public ResponseEntity<List<User>> getAllUser(){
        //List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id ){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @PostMapping("/postuser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserUpdateDto userDto, @PathVariable("id") Long id){
        userDto.setId(id);
        return new ResponseEntity<>(userService.updateUser(userDto),HttpStatus.OK);
    }
}
