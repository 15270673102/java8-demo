package com.example.demo.Stream;

import cn.hutool.core.lang.Console;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("fds", 23));
        list.add(new User("gfgfd", 11));
        list.add(new User("ewrew", 44));
        list.add(new User("adfa", 66));
        list.add(new User("gfdgfd", 77));

        List<String> collect = list.stream()
                .filter(user -> user.getAge() > 50)
                .sorted(Comparator.comparing(User::getName))
                .map(User::getName).collect(Collectors.toList());
        Console.log(collect);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        private String name;
        private Integer age;
    }
}
