package com.foodbackend.service;

import com.foodbackend.model.Restaurant;
import com.foodbackend.model.RestaurantResponse;
import com.foodbackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;
    public RestaurantResponse addrestaurant(Restaurant restaurant) {
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        restaurantRepository.save(restaurant);
        restaurantResponse.setFlag(true);
        restaurantResponse.setMsg("Added new Restaurant");
        return restaurantResponse;
    }
}
