package com.guidev.concurrentorders.service;

import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {

    public void processOrder() throws InterruptedException {

        System.out.println(
                "Iniciando processamento na thread: "
                        + Thread.currentThread()
        );

        simulateExternalCall("Estoque", 100);
        simulateExternalCall("Pagamento", 300);
        simulateExternalCall("Frete", 200);

        System.out.println(
                "Pedido finalizado na thread: "
                        + Thread.currentThread()
        );
    }

    private void simulateExternalCall(String service, long delay)
            throws InterruptedException {

        System.out.println(
                "Chamando " + service
                        + " | Thread: "
                        + Thread.currentThread()
        );

        Thread.sleep(delay);

        System.out.println(
                service + " respondeu"
                        + " | Thread: "
                        + Thread.currentThread()
        );
    }
}