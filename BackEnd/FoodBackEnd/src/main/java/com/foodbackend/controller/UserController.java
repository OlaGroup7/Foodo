package com.foodbackend.controller;

import com.foodbackend.model.*;
import com.foodbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    @PostMapping(value = "/addfood", consumes = "application/json")
    public FoodAddResponse addfood(@RequestBody Food food){
        FoodAddResponse foodAddResponse =userService.addfood(food);
        return foodAddResponse;
    }

    @PostMapping(value = "/fetchfood", consumes = "application/json")
    public ArrayList<Food> fetch(@RequestBody Food food){
        ArrayList<Food> foodlist = new ArrayList<>();
        foodlist = userService.fetchlist(food);
        return foodlist;
    }

}
