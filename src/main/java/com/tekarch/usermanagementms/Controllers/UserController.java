package com.tekarch.usermanagementms.Controllers;

import com.tekarch.usermanagementms.Models.User;
import com.tekarch.usermanagementms.Services.Interfaces.UserService;
import com.tekarch.usermanagementms.Services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userServiceImpl.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/users/{user_id}")
    public User getUser(@PathVariable("user_id") Long user_id) {
        return userServiceImpl.getUser(user_id);
    }

    @PutMapping("/users/{user_id}")
    public User updateUser(@PathVariable("user_id") Long user_id, @RequestBody User userData) {
        return userServiceImpl.updateUser(user_id,userData);
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable("user_id") Long user_id) {
        userServiceImpl.deleteUser(user_id);
        return new ResponseEntity<>("User with ID " + user_id + " has been deleted", HttpStatus.OK);
    }

    //User personal info endpoints

    @PutMapping("/users/{user_id}/personal-info")
    public User updateUserPersonalInfo(@PathVariable("user_id") Long user_id, @RequestBody User userData) {
        return userServiceImpl.updateUserPersonalInfo(user_id,userData);
    }

    @GetMapping("/users/{user_id}/personal-info")
    public User getUserPersonalInfo(@PathVariable("user_id") Long user_id) {
        return userServiceImpl.getUserPersonalInfo(user_id);
    }

    //KYC endpoints
    @PostMapping("/users/{user_id}/kyc")
    public ResponseEntity<User> submitKycInfo(@RequestBody User user) {
        return new ResponseEntity<>(userServiceImpl.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{user_id}/kyc")
    public User getUserKyc(Long user_id) {
        return userServiceImpl.getUser(user_id);
    }

    @PutMapping("/users/{user_id}/kyc")
    public User updateUserKyc(@PathVariable("user_id") Long user_id, @RequestBody User userData) {
        return userServiceImpl.updateUser(user_id,userData);
    }

    @DeleteMapping("/users/{user_id}/kyc")
    public ResponseEntity<String> deleteUserKyc(@PathVariable("user_id") Long user_id) {
        userServiceImpl.deleteUser(user_id);
        return new ResponseEntity<>("User with ID " + user_id + " has been deleted", HttpStatus.OK);
    }



}


