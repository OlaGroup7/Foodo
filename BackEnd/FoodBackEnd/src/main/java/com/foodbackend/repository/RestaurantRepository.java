package com.foodbackend.repository;

import com.foodbackend.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant,Long> {
    Restaurant findBy_id(String restaurantID);
}
