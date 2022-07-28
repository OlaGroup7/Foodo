package com.foodbackend.controller;

import com.foodbackend.model.*;
import com.foodbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping(value = "/addcart", consumes = "application/json", produces = "application/json")
    public CartResponse addCart(@RequestBody Cart cart){
        System.out.println("Controller");
        CartResponse cartResponse = cartService.addCart(cart);
        return cartResponse;
    }

    @GetMapping(value = "showcart/{id}", produces = "application/json")
    public ArrayList<Cart> userCart(@PathVariable String id){
        ArrayList<Cart> ac = cartService.userCart(id);
        return ac;
    }


//
    @PostMapping(value = "/updatecart", consumes = "application/json", produces = "application/json")
    public OrderResponse updateCart(@RequestBody Updateorder updateorder){
        OrderResponse orderResponse = cartService.updateCart(updateorder);
        return orderResponse;
    }

}
