package com.example.demo.CompletableFuture;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(() -> System.out.println("11111111111111"));

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("--------2");
            int a = 3 / 0;
            return 1;
        }).exceptionally(throwable -> {
            throwable.printStackTrace();
            return 5;
        }).thenApply(integer -> integer + 1).thenApply(integer -> integer + 2);
        System.out.println("future = " + future.get());

        System.out.println("----------------");
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            return 10;
        });
        System.out.println(future1.thenCompose(integer -> CompletableFuture.supplyAsync(() -> {
            return integer + 1;
        })).get());



    }
}
