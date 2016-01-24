package com.tom.futures;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;
import static org.fest.assertions.Assertions.assertThat;

public class MultiShopTest {

    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                     new Shop("Walmart"),
                                     new Shop("Radio Shack"),
                                     new Shop("Circuit City"),
                                     new Shop("Circuit City2"),
                                     new Shop("Circuit City3"),
                                     new Shop("Amazon"));

    @Test
    public void shouldFindPriceAtAllShops_Sequential() {
        String productName = "iPhone 27S";
        long start = System.currentTimeMillis();
        List<String> prices = shops.parallelStream()
                                   .map(shop -> {
                                       double price = 0;
                                       try {
                                           price = shop.getPrice(productName).get();
                                           return String.format("%s price is %.2f", shop.name,
                                                                price);
                                       } catch (Exception e) {
                                           return String.format("%s unable to price", shop.name);
                                       }

                                   })
                                   .collect(toList());
        assertThat(prices).hasSize(shops.size());
        System.out.println(prices);
        System.out.println("Sequential Time: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void shouldFindPriceAtAllShops_FutureJoin() {
        String productName = "iPhone 27S";
        long start = System.currentTimeMillis();
        List<CompletableFuture<Pair<String, Double>>> futures = shops.stream()
                                                       .map(shop -> shop.getPrice2(productName))
                                                       .collect(toList());
        assertThat(futures).hasSize(shops.size());
        List<String> prices = futures.stream()
                                     .map(this::formatPrice)
                                     .collect(toList());
        System.out.println(prices);
        System.out.println("FutureJoin Time: " + (System.currentTimeMillis() - start));
    }

    private String formatPrice(CompletableFuture<Pair<String, Double>> shopPrice) {
        try {
            Pair<String, Double> price = shopPrice.get();
            return String.format("%s price is %.2f",
                                 price.getLeft(),
                                 price.getRight());
        } catch (Exception e) {
            return "Unable to price";
        }
    }

}
