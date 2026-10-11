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

        orderConcurrencyService.processOrders(orders);

        long end = System.nanoTime();

        return Map.of(
                "strategy", "Platform Threads",
                "orders", orders,
                "durationMs", (end - start) / 1_000_000
        );
    }
}
