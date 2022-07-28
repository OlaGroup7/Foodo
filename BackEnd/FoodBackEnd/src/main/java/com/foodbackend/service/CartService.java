package com.foodbackend.service;

import com.foodbackend.model.Cart;
import com.foodbackend.model.CartResponse;
import com.foodbackend.model.ShowCart;
import com.foodbackend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    public CartResponse addcart(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        long quantity = cart.getQuantity();
        long price = cart.getUnitprice();
        long totalprice = quantity*price;
        cart.setTotalprice(totalprice);
        cartRepository.save(cart);
        cartResponse.setFlag(true);
        cartResponse.setMsg("Items Added");
        return cartResponse;
    }


    public ArrayList<Cart> usercart(String id) {
        ArrayList<Cart> uc = cartRepository.findByuserID(id);
        return uc;
    }
}
