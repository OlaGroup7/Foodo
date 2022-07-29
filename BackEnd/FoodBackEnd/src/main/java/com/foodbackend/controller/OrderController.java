package com.foodbackend.controller;

import com.foodbackend.model.CheckOutResponse;
import com.foodbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/cart/confirmorder/{userId}", produces = "application/json")
    public ResponseEntity<CheckOutResponse> confirmOrder(@PathVariable String userId){
        CheckOutResponse checkOutResponse = orderService.deleteFromCartAndAddToOrder(userId);
        return new ResponseEntity<>(checkOutResponse, HttpStatus.OK);
    }


}