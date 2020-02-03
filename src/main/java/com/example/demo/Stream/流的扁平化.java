package com.example.demo.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 流的扁平化 {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");

        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.err::println);
    }
}
