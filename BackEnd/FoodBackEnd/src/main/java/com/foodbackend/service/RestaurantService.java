package com.foodbackend.service;

import com.foodbackend.model.Restaurant;
import com.foodbackend.model.RestaurantAddResponse;
import com.foodbackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;
    public RestaurantAddResponse addrestaurant(Restaurant restaurant) {
        RestaurantAddResponse restaurantAddResponse = new RestaurantAddResponse();
        restaurantRepository.save(restaurant);
        restaurantAddResponse.setFlag(true);
        restaurantAddResponse.setMsg("Added new Restaurant");
        return restaurantAddResponse;
    }
}
