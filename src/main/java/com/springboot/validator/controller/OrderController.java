package com.springboot.validator.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.validator.bean.BeanValidator;
import com.springboot.validator.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
  @GetMapping("/add")
  public String add(@RequestBody String json) {
    Order order = JSON.parseObject(json, Order.class);
    BeanValidator.validate(order, Order.Create.class);
    return order.toString();
  }

  @GetMapping("/update")
  public String update(@RequestBody String json) {
    Order order = JSON.parseObject(json, Order.class);
    BeanValidator.validate(order, Order.Update.class);
    return order.toString();
  }
}
