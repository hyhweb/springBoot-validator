package com.springboot.validator.controller;

import com.alibaba.fastjson.JSON;
import com.springboot.validator.bean.BeanValidator;
import com.springboot.validator.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

  @GetMapping("/save")
  public String save(@RequestBody String json) {
    Order order = JSON.parseObject(json, Order.class);
    BeanValidator.validate(order);
    log.info(order.toString());
    return order.toString();
  }

  @GetMapping("/add")
  public String add(@RequestBody String json) {
    Order order = JSON.parseObject(json, Order.class);
    BeanValidator.validate(order, Order.Create.class);
    log.info(JSON.toJSONString(order));
    return order.toString();
  }

  @GetMapping("/update")
  public String update(@RequestBody String json) {
    Order order = JSON.parseObject(json, Order.class);
    BeanValidator.validate(order, Order.Update.class);
    log.info("{}", order);
    return order.toString();
  }
}
