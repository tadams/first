package com.tom.futures;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    Shop shop = new Shop("Test Shop");

    @Test
         public void shouldPriceProduct() throws Exception {
        CompletableFuture<Double> mousePrice = shop.getPrice("mouse");
        System.out.println("Waiting ...");
        double price = mousePrice.get();
        System.out.println("Have the price...");
        assertThat(price).isGreaterThan(0);
    }

    @Test
    public void shouldPriceProduct2() throws Exception {
        CompletableFuture<Double> mousePrice = shop.getPrice("mouse");
        System.out.println("Waiting ...");
        double price = mousePrice.get();
        System.out.println("Have the price..." + price);
        assertThat(price).isGreaterThan(0);
    }

    @Test(expected = ExecutionException.class)
         public void shouldPropagateErrorFromFuture() throws Exception {
        CompletableFuture<Double> mousePrice = shop.getPrice("error");
        mousePrice.get();
    }

    @Test(expected = ExecutionException.class)
    public void shouldPropagateErrorFromFuture2() throws Exception {
        CompletableFuture<Pair<String, Double>> mousePrice = shop.getPrice2("error");
        try {
            mousePrice.get();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}