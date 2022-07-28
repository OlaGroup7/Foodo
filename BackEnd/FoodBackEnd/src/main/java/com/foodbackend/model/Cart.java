package com.foodbackend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("cart")
public class Cart {
    @Id
    private long cartId;
    private String userID;
    private  String restaurantID;
    private String foodname;
    private long quantity;
    private long unitprice;
    private long totalprice;
    private String _id;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(long unitprice) {
        this.unitprice = unitprice;
    }

    public long getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(long totalprice) {
        this.totalprice = totalprice;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
