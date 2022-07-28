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
    public CartResponse addCart(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        long quantity = cart.getQuantity();
        long price = cart.getUnitPrice();
        long totalprice = quantity*price;
        cart.setTotalPrice(totalprice);
        cartRepository.save(cart);
        cartResponse.setFlag(true);
        cartResponse.setMsg("Items Added");
        return cartResponse;
    }


    public ArrayList<Cart> userCart(String id) {
        ArrayList<Cart> uc = cartRepository.findByuserID(id);
        return uc;
    }

    public OrderResponse updateCart(Updateorder updateorder){

        OrderResponse orderResponse = new OrderResponse();
        if(updateorder.getQuantity() > 0){
            Cart cart = cartRepository.findByuserIDAndFoodName(updateorder.getUserID(), updateorder.getFoodName());
            System.out.println(cart.getFoodName());
            cartRepository.deleteByuserIDAndFoodName(updateorder.getUserID(),updateorder.getFoodName());
            cart.setQuantity(updateorder.getQuantity());
            cart.setTotalPrice(updateorder.getQuantity() * cart.getUnitPrice());
            cartRepository.save(cart);
            orderResponse.setFlag(true);
            orderResponse.setMsg("Updated Cart");
        }else{
            cartRepository.deleteByuserIDAndFoodName(updateorder.getUserID(),updateorder.getFoodName());
            orderResponse.setFlag(true);
            orderResponse.setMsg("Deleted from Cart");
        }
        return orderResponse;
    }
}
