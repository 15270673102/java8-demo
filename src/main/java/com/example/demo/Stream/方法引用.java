package com.example.demo.Stream;

import cn.hutool.core.lang.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @auther: wangjiayu
 * @date: 2020/1/17 13:53
 */
public class 方法引用 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 1234);
        Optional<Integer> reduce = integers.stream().reduce(Math::max);
        reduce.ifPresent(System.err::println);

        List<String> strings = Arrays.asList("how", "to", "do", "in", "java", "dot", "com");
        List<String> collect = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
        Console.log(collect);

        List<Integer> collect1 = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        Console.log(collect1);

    }

}
