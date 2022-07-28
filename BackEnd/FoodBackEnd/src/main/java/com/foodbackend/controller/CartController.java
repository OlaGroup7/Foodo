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
    public CartResponse addcart(@RequestBody Cart cart){
        System.out.println("Controller");
        CartResponse cartResponse = cartService.addcart(cart);
        return cartResponse;
    }

    @GetMapping(value = "showcart/{id}", produces = "application/json")
    public ArrayList<Cart> usercart(@PathVariable String id){
        ArrayList<Cart> ac = cartService.usercart(id);
        return ac;
    }


//
//    @PostMapping(value = "/updatecart", consumes = "application/json", produces = "application/json")
//    public OrderResponse updatecart(@RequestBody Updateorder updateorder){
//        OrderResponse orderResponse = cartService.updatecart(updateorder);
//        return orderResponse;
//    }

}
