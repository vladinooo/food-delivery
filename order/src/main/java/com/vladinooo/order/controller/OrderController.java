package com.vladinooo.order.controller;

import com.vladinooo.order.dto.OrderDto;
import com.vladinooo.order.dto.SavedOrderDto;
import com.vladinooo.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place-order")
    public ResponseEntity<SavedOrderDto> placeOrder(@RequestBody OrderDto orderDto) {
        SavedOrderDto savedOrder = orderService.addOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }


}
