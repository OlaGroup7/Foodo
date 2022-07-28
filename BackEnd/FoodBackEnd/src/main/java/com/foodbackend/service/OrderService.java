package com.foodbackend.service;

import com.foodbackend.model.*;
import com.foodbackend.repository.CartRepository;
import com.foodbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

//    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository cartRepository;

    public CheckOutResponse deleteFromCartAndAddToOrder(String userID){
//        User user = userRepository.findBy_id(userID);

        CheckOutResponse checkOutResponse = new CheckOutResponse();

//        if(user == null){
//            buyResponse.setStatus(false);
//            buyResponse.setMessage("User Not Found");
//            return buyResponse;
//        }else{
        ArrayList<Cart> carts = cartRepository.findByuserID(userID);
        Order order = new Order();
        long sum = 0;
        order.setUserID(userID);
        for(Cart cart: carts){
            order.setFoodList(cart.getFoodName());
            order.setPriceList(cart.getUnitPrice());
            order.setQuantityList(cart.getQuantity());
            sum += cart.getTotalPrice();
        }
        order.setTotalPrice(sum);
//
        orderRepository.save(order);
        cartRepository.deleteByuserID(userID);
        checkOutResponse.setStatus(true);
        checkOutResponse.setMessage("User Order Placed");
        return checkOutResponse;
//        }
    }
}