package com.example.demo.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class 时间 {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        System.out.println("localDateTime.toLocalDate() = " + localDateTime.toLocalDate());
        System.out.println("localDateTime.toLocalTime() = " + localDateTime.toLocalTime());
        System.out.println("localDateTime.format(DateTimeFormatter.ISO_DATE_TIME) = " + localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("localDateTime.format(DateTimeFormatter.ofPattern(\"yyyy-MM-DD HH:mm:ss\")) = " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        System.out.println("-----");

        LocalTime localTime = LocalTime.of(12, 45, 20);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());
        System.out.println(localTime.get(ChronoField.HOUR_OF_DAY));
        System.out.println(localTime.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("localTime.get(ChronoField.SECOND_OF_MINUTE) = " + localTime.get(ChronoField.SECOND_OF_MINUTE));


        System.out.println("-----");
        java.time.LocalDate localDate = java.time.LocalDate.of(2020, 1, 1);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.lengthOfMonth());
        System.out.println(java.time.LocalDate.now());
        System.out.println("-----");

        System.out.println(localDate.get(ChronoField.YEAR));
        System.out.println(localDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(localDate.get(ChronoField.DAY_OF_MONTH));

        System.out.println("LocalDate.parse(\"2020-01-02\") = " + LocalDate.parse("2020-01-02"));
        System.out.println("LocalTime.parse(\"12:12:12\") = " + LocalTime.parse("12:12:12"));

        System.out.println("LocalDateTime.of(localDate,localTime) = " + LocalDateTime.of(localDate, localTime));
        System.out.println("localDate.atTime(localTime) = " + localDate.atTime(localTime));
        System.out.println("localTime.atDate(localDate) = " + localTime.atDate(localDate));

    }

}
