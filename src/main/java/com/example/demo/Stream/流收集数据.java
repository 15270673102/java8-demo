package com.example.demo.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class 流收集数据 {

    public static void main(String[] args) {

        List<Test2.Dish> menu = Arrays.asList(
                new Test2.Dish("pork", false, 800, Test2.Dish.Type.MEAT),
                new Test2.Dish("beef", false, 700, Test2.Dish.Type.MEAT),
                new Test2.Dish("chicken", false, 400, Test2.Dish.Type.MEAT),
                new Test2.Dish("french fries", true, 530, Test2.Dish.Type.OTHER),
                new Test2.Dish("rice", true, 350, Test2.Dish.Type.OTHER),
                new Test2.Dish("season fruit", true, 120, Test2.Dish.Type.OTHER),
                new Test2.Dish("pizza", true, 550, Test2.Dish.Type.OTHER),
                new Test2.Dish("prawns", false, 300, Test2.Dish.Type.FISH),
                new Test2.Dish("salmon", false, 450, Test2.Dish.Type.FISH));


        //分区
        System.err.println(menu.stream().collect(partitioningBy(Test2.Dish::isVegetarian)));
        System.err.println(menu.stream().collect(groupingBy(Test2.Dish::isVegetarian)));
        System.err.println(menu.stream().collect(partitioningBy(Test2.Dish::isVegetarian, mapping(Test2.Dish::getName, toSet()))));
        System.err.println(menu.stream().collect(groupingBy(Test2.Dish::isVegetarian, mapping(Test2.Dish::getName, toSet()))));

        //分组
        System.err.println("--------------------");
        System.err.println(menu.stream().collect(groupingBy(Test2.Dish::getType, counting())));
        System.err.println(menu.stream().collect(groupingBy(Test2.Dish::getType, maxBy(Comparator.comparingInt(Test2.Dish::getCalories)))));
        System.err.println(menu.stream().collect(groupingBy(Test2.Dish::getType,
                collectingAndThen(maxBy(Comparator.comparingInt(Test2.Dish::getCalories)), Optional::get))));

        System.err.println(menu.stream().collect(groupingBy(Test2.Dish::getType, summingInt(Test2.Dish::getCalories))));
        System.err.println(menu.stream().collect(groupingBy(Test2.Dish::getType, mapping(Test2.Dish::getName, toSet()))));

        //分组
        System.err.println("--------------------");
        System.err.println(menu.stream().collect(groupingBy(Test2.Dish::getType)));
        System.err.println(menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        })));


        //拼接
        System.err.println("--------------------");
        System.err.println(menu.stream().map(Test2.Dish::getName).collect(Collectors.joining()));
        System.err.println(menu.stream().map(Test2.Dish::getName).collect(Collectors.joining("**")));

        //多种求值
        System.err.println("--------------------");
        System.err.println(menu.stream().collect(Collectors.summarizingInt(Test2.Dish::getCalories)));

        System.err.println("--------------------");
        System.err.println(menu.stream().collect(Collectors.summingInt(Test2.Dish::getCalories)));

        System.err.println("--------------------");
        System.err.println(menu.stream().max(Comparator.comparingInt(Test2.Dish::getCalories)));

        System.err.println("--------------------");
        System.err.println(menu.stream().collect(counting()));
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}

}
