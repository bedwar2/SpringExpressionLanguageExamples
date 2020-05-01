package com.example.speldemo.controller;

import com.example.speldemo.model.Order;
import com.example.speldemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController
{

    @Autowired
    Order order;

    @Autowired
    User user;

    @GetMapping("/GetOrder")
    public Order getOrder() {
        return order;
    }

    @GetMapping("/getUser")
    public User getUser() {
        return user;
    }
}
