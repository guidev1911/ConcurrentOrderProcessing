package com.guidev.concurrentorders.controller;

import com.guidev.concurrentorders.service.OrderProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProcessingService orderProcessingService;

    @PostMapping("/process")
    public String processOrder() throws InterruptedException {

        orderProcessingService.processOrder();

        return "Pedido processado com sucesso";
    }
}