package com.foodbackend.repository;

import com.foodbackend.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface CartRepository extends MongoRepository<Cart,Long> {
    ArrayList<Cart> findByuserID(String userID);
}
