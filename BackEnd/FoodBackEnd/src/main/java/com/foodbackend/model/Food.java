package com.foodbackend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document("food")
public class Food {
    @Id
    private long foodID;
    @Column(nullable = false)
    private String restaurantID;
    @Column(nullable = false,length = 55)
    private String foodName;
    @Column(nullable = false,length = 30)
    private String cuisineType;
    private double price;

    public long getFoodID() {
        return foodID;
    }

    public void setFoodID(long foodID) {
        this.foodID = foodID;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
