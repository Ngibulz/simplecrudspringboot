package com.example.demo1111111111.service;

import com.example.demo1111111111.dto.UserUpdateDto;
import com.example.demo1111111111.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(UserUpdateDto userDto);

    void deleteUser(Long userId);
}
