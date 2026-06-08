package com.himan.microservices.order.controller;

import com.himan.microservices.order.dto.OrderRequest;
import com.himan.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.FOUND)
    public String testServer(){
        return "Servers Tested Successfully";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order Placed SuccessFully";
    }
}
