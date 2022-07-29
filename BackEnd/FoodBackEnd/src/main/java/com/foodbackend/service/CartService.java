package com.foodbackend.service;

import com.foodbackend.model.*;
import com.foodbackend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    public CartAddResponse addCart(Cart cart) {
        CartAddResponse cartAddResponse = new CartAddResponse();
        long quantity = cart.getQuantity();
        long price = cart.getUnitPrice();
        long totalPrice = quantity * price;
        cart.setTotalPrice(totalPrice);
        cartRepository.save(cart);
        cartAddResponse.setFlag(true);
        cartAddResponse.setMsg("Items Added");
        return cartAddResponse;
    }


    public ArrayList<Cart> userCart(String id) {
        ArrayList<Cart> cart = cartRepository.findByuserID(id);
        return cart;
    }

    public CartUpdateResponse updateCart(UpdateOrder updateorder){

        CartUpdateResponse cartUpdateResponse = new CartUpdateResponse();
        if(updateorder.getQuantity() > 0){
            Cart cart = cartRepository.findByuserIDAndFoodName(updateorder.getUserID(), updateorder.getFoodName());
            System.out.println(cart.getFoodName());
            cartRepository.deleteByuserIDAndFoodName(updateorder.getUserID(),updateorder.getFoodName());
            cart.setQuantity(updateorder.getQuantity());
            cart.setTotalPrice(updateorder.getQuantity() * cart.getUnitPrice());
            cartRepository.save(cart);
            cartUpdateResponse.setFlag(true);
            cartUpdateResponse.setMsg("Food Detail Updated in Cart");
        }else{
            cartRepository.deleteByuserIDAndFoodName(updateorder.getUserID(),updateorder.getFoodName());
            cartUpdateResponse.setFlag(true);
            cartUpdateResponse.setMsg("Food Item Deleted from Cart");
        }
        return cartUpdateResponse;
    }
}
