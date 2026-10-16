package com.guidev.concurrentorders.controller;

import com.guidev.concurrentorders.service.OrderConcurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/concurrency")
@RequiredArgsConstructor
public class ConcurrencyController {

    private final OrderConcurrencyService orderConcurrencyService;

    @PostMapping("/platform")
    public Map<String, Object> testPlatformThreads(
            @RequestParam(defaultValue = "100") int orders
    ) throws InterruptedException {

        long start = System.nanoTime();

        orderConcurrencyService.processOrdersWithPlatformThreads(orders);

        long duration = (System.nanoTime() - start) / 1_000_000;
        double ordersPerSecond = orders / (duration / 1000.0);

        return Map.of(
                "strategy", "Platform Threads",
                "orders", orders,
                "durationMs", duration,
                "ordersPerSecond", Math.round(ordersPerSecond * 100.0) / 100.0
        );
    }

    @PostMapping("/virtual")
    public Map<String, Object> testVirtualThreads(
            @RequestParam(defaultValue = "100") int orders
    ) throws InterruptedException {

        long start = System.nanoTime();

        orderConcurrencyService.processOrdersWithVirtualThreads(orders);

        long duration = (System.nanoTime() - start) / 1_000_000;
        double ordersPerSecond = orders / (duration / 1000.0);

        return Map.of(
                "strategy", "Virtual Threads",
                "orders", orders,
                "durationMs", duration,
                "ordersPerSecond", Math.round(ordersPerSecond * 100.0) / 100.0
        );
    }
}
