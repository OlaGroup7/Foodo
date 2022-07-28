package com.foodbackend.model;

import java.util.ArrayList;

public class OrderResponse {
    private boolean flag;
    private String msg;
    private ArrayList<Cart> foodtobuy;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<Cart> getFoodtobuy() {
        return foodtobuy;
    }

    public void setFoodtobuy(ArrayList<Cart> foodtobuy) {
        this.foodtobuy = foodtobuy;
    }
}
