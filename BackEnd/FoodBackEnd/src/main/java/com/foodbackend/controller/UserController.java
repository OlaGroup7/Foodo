package com.foodbackend.controller;

import com.foodbackend.model.*;

import com.foodbackend.service.FoodService;

import com.foodbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

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
    public FoodResponse addfood(@RequestBody Food food){

        FoodResponse foodResponse=userService.addfood(food);
        return foodResponse;
    }
    @GetMapping(value = "/showRestaurantDetails",produces ="application/json")
    public ArrayList<Food> fetch(@RequestParam String _id, String cuisine){

        ArrayList<Food> foodlist = userService.fetchlist(_id, cuisine);
        return foodlist;
    }


    @Autowired
    FoodService foodService;
    @GetMapping(value="/searchResultsbyCuisine/{cuisine}")
    public ArrayList<Restaurant> searchByCuisine(@PathVariable String cuisine)
    {
        //System.out.println(cuisine);
        ArrayList<Restaurant> restaurants = foodService.searchByCuisine(cuisine);
        return restaurants;
    }

}
