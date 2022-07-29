package com.foodbackend.service;

import com.foodbackend.model.Food;
import com.foodbackend.model.Restaurant;
import com.foodbackend.repository.FoodRepository;
import com.foodbackend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    public ArrayList<Restaurant> searchByCuisine(String cuisine) {
        ArrayList<Food> food = foodRepository.findByCuisineType(cuisine);
        System.out.println(food);
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        Set<String> resUniqueId = new HashSet<String>();
        for(Food s:food)
        {
            String resId = s.getRestaurantID();
            resUniqueId.add(resId);
        }
//        for(Food s:food)
//        {   String resId = s.getRestaurantID();
//            //System.out.println(s);
//            Restaurant restaurant = restaurantRepository.findBy_id(resId);
//            restaurants.add(restaurant);
//        }
        for(String resId:resUniqueId)
        {
            Restaurant restaurant = restaurantRepository.findBy_id(resId);
            restaurants.add(restaurant);
        }
        return restaurants;
    }
}
