package com.tom.futures;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
public class Shop {

    final String name;

    private Random random = new Random();

    private final Executor executor =
            Executors.newFixedThreadPool(25,
                                         r -> {
                                         Thread t = new Thread(r);
                                         t.setDaemon(true);
                                         return t;
                                     });

    public CompletableFuture<Double> getPrice(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product).getRight();
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    public CompletableFuture<Pair<String, Double>> getPrice2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product), executor);
    }

    private Pair<String, Double> calculatePrice(String product) {
        if ("error".equals(product)) throw new RuntimeException("Product not found");
        delay();
        double price = random.nextDouble() *
                   (product.charAt(0) +
                    product.charAt(1));
        return Pair.of(name, price);
    }

    public static void delay() {
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
