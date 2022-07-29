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
    public CartAddResponse addCart(@RequestBody Cart cart){
        CartAddResponse cartAddResponse = cartService.addCart(cart);
        return cartAddResponse;
    }

    @GetMapping(value = "showcart/{id}", produces = "application/json")
    public ArrayList<Cart> userCart(@PathVariable String id){
        ArrayList<Cart> userCart = cartService.userCart(id);
        return userCart;
    }


//
    @PostMapping(value = "/updatecart", consumes = "application/json", produces = "application/json")
    public CartUpdateResponse updateCart(@RequestBody UpdateOrder updateorder){
        CartUpdateResponse cartUpdateResponse = cartService.updateCart(updateorder);
        return cartUpdateResponse;
    }

}
