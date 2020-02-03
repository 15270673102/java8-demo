package com.example.demo.Stream;

import cn.hutool.core.lang.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @auther: wangjiayu
 * @date: 2020/1/17 13:53
 */
public class 方法引用 {

    public static void main(String[] args) {

        System.err.println("------------------------");
        Stream.generate(Math::random).limit(5).forEach(System.err::println);

        System.err.println("------------------------");
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.err::println);

        System.err.println("------------------------");
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 1234);
        integers.stream().reduce(Math::max).ifPresent(System.err::println);

        System.err.println("------------------------");
        List<String> strings = Arrays.asList("how", "to", "do", "in", "java", "dot", "com");
        strings.stream().sorted(String::compareTo).collect(Collectors.toList()).forEach(System.err::println);

        System.err.println("------------------------");
        IntStream.range(1, 10).boxed().collect(Collectors.toList()).forEach(System.err::println);


    }

}
