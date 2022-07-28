package com.foodbackend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document("order")
public class Order {

    private String _id;

    @Id
    private long orderID;

    private String restaurantID;

    private String userID;
    private Long totalPrice;
    private ArrayList<Long> priceList = new ArrayList<>();
    private ArrayList<Long> quantityList = new ArrayList<>();
    private ArrayList<String> foodList = new ArrayList<>();

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }



    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Long> getPriceList() {
        return this.priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList.add(priceList);
    }

    public ArrayList<Long> getQuantityList() {
        return this.quantityList;
    }

    public void setQuantityList(Long quantityList) {
        this.quantityList.add(quantityList);
    }

    public ArrayList<String> getFoodList() {
        return this.foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList.add(foodList);
    }
}
