package com.esther.fashion_ecommerce.controller;

import ch.qos.logback.core.model.Model;
import com.esther.fashion_ecommerce.model.User;
import com.esther.fashion_ecommerce.payload.LoginDto;
import com.esther.fashion_ecommerce.payload.UserDto;
import com.esther.fashion_ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    //-----------------------------------------------------------
    // Sign up a user using the createAUser method of this PostMapping.
    //-----------------------------------------------------------
    @PostMapping(path = "/createUser")
    public ResponseEntity<?> createAUser(@RequestBody @Valid UserDto userDto){
        User aUser = userService.createUser(userDto);
        return new ResponseEntity<>(aUser, HttpStatus.CREATED);
    }

    @GetMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
        String user = userService.login(loginDto);
        if (user.equals("success")){
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping(path = "/getUsers")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping(path = "/getUser/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.updateUser(id, userDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted!!!", HttpStatus.NO_CONTENT);
    }

}
