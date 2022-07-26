package com.foodbackend.service;

import com.foodbackend.model.HomePageUserDetails;
import com.foodbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public HomePageUserDetails fetchUserHomePageDetails(String userID)
    {
        HomePageUserDetails homePageUserDetails = new HomePageUserDetails(); //need to add the jpa methods like findbyID to fetch name and address
        return homePageUserDetails;
    }
}
