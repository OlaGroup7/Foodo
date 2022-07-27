package com.foodbackend.controller;

import com.foodbackend.model.HomePageUserDetails;
import com.foodbackend.model.LoginRequest;
import com.foodbackend.model.LoginResponse;
import com.foodbackend.model.SignUpResponse;
import com.foodbackend.model.User;
import com.foodbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/home-customer/{_id}")
    public HomePageUserDetails homePageDetails(@PathVariable String _id)
    {
        HomePageUserDetails homePageUserDetails = userService.fetchUserHomePageDetails(_id);
        return homePageUserDetails;
    }
    
    @PostMapping(value="/login",consumes = "application/json",produces = "application/json")
    public LoginResponse loginreq(@RequestBody LoginRequest loginRequest)
    {
        LoginResponse loginResponse = userService.authenticate(loginRequest);
        return loginResponse;
    }
    @PostMapping(value = "/signup", consumes = "application/json", produces = "application/json")
    public SignUpResponse signup(@RequestBody User user){
        SignUpResponse signUpResponse = userService.register(user);
        return signUpResponse;
    }
}
