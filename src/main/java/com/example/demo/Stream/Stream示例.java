package com.example.demo.Stream;

import cn.hutool.core.lang.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @auther: wangjiayu
 * @date: 2020/1/17 14:11
 */
public class Stream示例 {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.forEach(System.err::println);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        List<Integer> collect = list.stream().filter(i -> i > 7).collect(Collectors.toList());
        Console.log(collect);

        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        memberNames.stream().filter(s -> s.startsWith("A")).forEach(System.err::println);
        System.err.println("------------");
        memberNames.stream().sorted().map(String::toUpperCase).forEach(System.err::println);
        System.err.println("------------");
        memberNames.stream().reduce(String::concat).ifPresent(System.err::println);
        memberNames.stream().reduce(((s1, s2) -> s1 + "#" + s2)).ifPresent(System.err::println);

    }

}
