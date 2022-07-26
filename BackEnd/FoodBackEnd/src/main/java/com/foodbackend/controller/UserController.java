package com.foodbackend.controller;

import com.foodbackend.model.HomePageUserDetails;
import com.foodbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/home-customer/{userID}")
    public HomePageUserDetails homePageDetails(@PathVariable("userID") String userID)
    {
        HomePageUserDetails homePageUserDetails = userService.fetchUserHomePageDetails(userID);
        return homePageUserDetails;
    }
}
