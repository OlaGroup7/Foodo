package com.foodbackend.controller;

import com.foodbackend.model.Restaurant;
import com.foodbackend.model.RestaurantResponse;
import com.foodbackend.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping(value = "/addrestaurant", consumes = "application/json", produces = "application/json")
    public RestaurantResponse addrestaurant(@RequestBody Restaurant restaurant){
        RestaurantResponse restaurantResponse = restaurantService.addrestaurant(restaurant);
        return restaurantResponse;
    }
}
