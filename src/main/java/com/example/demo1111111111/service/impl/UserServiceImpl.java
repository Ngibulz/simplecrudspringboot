package com.example.demo1111111111.service.impl;

import com.example.demo1111111111.dto.UserUpdateDto;
import com.example.demo1111111111.entity.User;
import com.example.demo1111111111.repository.UserRepository;
import com.example.demo1111111111.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        var x = userRepository.findAll();
        System.out.println(Arrays.toString(x.toArray()));
        //System.out.println(Arrays.toString(list.toArray()));
        return x;
    }

    @Override
    public User createUser(User user) {
        user.setFullName(user.getFirstName()+" "+user.getLastName());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        User optionalUser = userRepository.findById(userId).get();
        return optionalUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(UserUpdateDto userDto) {
        Optional<User> currentUser = userRepository.findById(userDto.getId());
        if (currentUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"testt");
        }
        User updateUser = currentUser.get();
        updateUser.setFirstName(userDto.getFirstName());
        updateUser.setLastName(userDto.getLastName());
        userRepository.save(updateUser);
        return updateUser;
    }
}

