
package com.guidev.concurrentorders.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class OrderConcurrencyService {

    public void processOrdersWithPlatformThreads(int numberOfOrders)
            throws InterruptedException {

        try (ExecutorService executor =
                     Executors.newFixedThreadPool(100)) {

            submitOrders(executor, numberOfOrders);
        }
    }

    public void processOrdersWithVirtualThreads(int numberOfOrders)
            throws InterruptedException {

        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            submitOrders(executor, numberOfOrders);
        }
    }

    private void submitOrders(
            ExecutorService executor,
            int numberOfOrders
    ) {
        for (int i = 1; i <= numberOfOrders; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }
}
