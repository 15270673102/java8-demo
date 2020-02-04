package com.example.demo.CompletableFuture;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> future = getPriceAsync("aaaaaaaaaaaaaa");
        System.out.println("future.get() = " + future.get());

        CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> calculatePrice("ttttttttttt"))
                //异常处理
                .exceptionally(throwable -> {
                    System.err.println(throwable.toString());
                    return 0.0;
                })
                .thenApply(aDouble -> aDouble + "xxx")
                .thenApply(s -> s + "???")
                .thenAccept(System.err::println);
        future1.get();

    }

    //异步
    public static CompletableFuture<Double> getPriceAsync(String product) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                completableFuture.complete(price);
            } catch (Exception e) {
                //异步异常
                completableFuture.completeExceptionally(e);
            }
        }).start();
        return completableFuture;
    }

    //异步2
    public static CompletableFuture<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private static double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
