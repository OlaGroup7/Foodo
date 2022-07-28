package com.foodbackend.repository;

import com.foodbackend.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.ArrayList;

public interface FoodRepository extends MongoRepository<Food, Long> {

    ArrayList<Food> findByRestaurantIDAndCuisineType(String restaurantID, String cuisineType);

    ArrayList<Food> findByCuisineType(String cuisineType);

}
