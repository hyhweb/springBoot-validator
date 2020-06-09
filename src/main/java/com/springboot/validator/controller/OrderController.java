package com.springboot.validator.controller;

import com.springboot.validator.bean.BeanValidator;
import com.springboot.validator.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
  @GetMapping("/add")
  public String addOrder(Order order) {
    // Order order = JSON.parseObject(json, Order.class);
    BeanValidator.validate(order, Order.Update.class);
    System.out.println("addOrder");
    System.out.println(order);
    return order.toString();
  }
}
