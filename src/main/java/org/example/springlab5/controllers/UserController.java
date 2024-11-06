package org.example.springlab5.controllers;

import org.example.springlab5.exceptions.ResourceNotFoundException;
import org.example.springlab5.models.User;
import org.example.springlab5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/user")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "id" ) long id, @RequestBody User user) throws ResourceNotFoundException {
        User user1= userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user1.setFirst_name(user.getFirst_name());
        user1.setLast_name(user.getLast_name());
        user1.setPassword(user.getPassword());
        user1.setRegistration_date(user.getRegistration_date());
        final User updatedUser = userRepository.save(user1);
        return ResponseEntity.ok().body(updatedUser);
    }
    @DeleteMapping("/deleteUser/{id}")
    public  Map<String,Boolean> deleteUser(@PathVariable(value = "id" ) long id) throws ResourceNotFoundException {
        User user1=userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found"));
        userRepository.delete(user1);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
