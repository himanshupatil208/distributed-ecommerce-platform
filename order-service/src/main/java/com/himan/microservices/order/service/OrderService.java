package com.himan.microservices.order.service;

import com.himan.microservices.order.client.InventoryClient;
import com.himan.microservices.order.dto.OrderRequest;
import com.himan.microservices.order.model.Order;
import com.himan.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest){

        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isProductInStock) {
            //map orderRequest to Order object
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            //save order to OrderRepository
            orderRepository.save(order);
        }
        else {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + "is not in stock.");
        }

    }




}
