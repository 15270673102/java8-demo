package com.example.demo.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


        System.err.println("---------------");

        System.err.println(menu.stream().map(Dish::getCalories).reduce(0, Integer::sum));
        System.err.println(menu.stream().mapToInt(Dish::getCalories).sum());
        System.err.println("---------------");

        menu.stream().findAny().ifPresent(System.err::println);
        menu.stream().findFirst().ifPresent(System.err::println);

        System.err.println("---------------");

        System.err.println(menu.stream().anyMatch(Dish::isVegetarian));
        System.err.println(menu.stream().anyMatch(dish -> dish.getName().equals("pork")));
        System.err.println(menu.stream().anyMatch(dish -> dish.getName().equals("pork1")));

        System.err.println("---------------");
        System.err.println(menu.stream().count());
        menu.stream().map(Dish::getCalories).reduce(Integer::max).ifPresent(System.err::println);
        menu.stream().map(Dish::getCalories).reduce(Integer::min).ifPresent(System.err::println);
        System.err.println(menu.stream().min(Comparator.comparing(Dish::getCalories)));
        System.err.println(menu.stream().max(Comparator.comparing(Dish::getCalories)));
        System.err.println("---------------");

        menu.stream().filter(dish -> dish.getCalories() > 400).collect(Collectors.toList()).forEach(System.err::println);
        System.err.println("---------------");

        menu.forEach(dish -> {
            dish.setName("xxxxxxxxxxxx");
        });
        menu.forEach(System.err::println);

        System.err.println("----");
        menu.stream().filter(dish -> dish.getCalories() > 400).limit(2).collect(Collectors.toList()).forEach(System.err::println);


        System.err.println("----");
        menu.stream().map(Dish::getName).collect(Collectors.toList()).forEach(System.err::println);
        System.err.println("----");
        menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList()).forEach(System.err::println);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Dish {
        private String name;
        private boolean vegetarian;
        private int calories;
        private Type type;

        enum Type {MEAT, FISH, OTHER;}
    }


}
