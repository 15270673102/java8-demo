package com.example.demo.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "tony");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "cafei");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "aaron");

        CompletableFuture<String> future = CompletableFuture.allOf(future1, future2, future3)
                .thenApply(v -> Stream.of(future1, future2, future3)
                        .map(CompletableFuture::join)
                        .collect(Collectors.joining(" ")));
        System.out.println(future.get());

    }
}
