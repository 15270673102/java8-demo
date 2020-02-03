package com.example.demo.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 练习 {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        //找出2011年的所有交易并按交易额排序（从低到高）
        transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getYear))
                .collect(Collectors.toList()).forEach(System.err::println);

        //交易员都在哪些不同的城市工作过
        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(Collectors.toList()).forEach(System.err::println);
        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet()).forEach(System.err::println);

        //查找所有来自于剑桥的交易员，并按姓名排序
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .distinct()
                .collect(Collectors.toList()).forEach(System.err::println);

        //返回所有交易员的姓名字符串，按字母顺序排序
        String collect = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct().sorted().collect(Collectors.joining(" "));
        System.err.println(collect);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Trader {
        private String name;
        private String city;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Transaction {
        private Trader trader;
        private int year;
        private int value;
    }

}
