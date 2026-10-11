 package com.guidev.concurrentorders.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class OrderConcurrencyService {

    public void processOrders(int numberOfOrders)
            throws InterruptedException {

        try (ExecutorService executor =
                     Executors.newFixedThreadPool(100)) {

            for (int i = 1; i <= numberOfOrders; i++) {
                int orderId = i;

                executor.submit(() -> {
                    try {
                        System.out.println(
                                "Pedido " + orderId
                                        + " | Thread: "
                                        + Thread.currentThread()
                        );

                        Thread.sleep(600);

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
}
