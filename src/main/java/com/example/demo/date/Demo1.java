package com.example.demo.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Demo1 {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        System.out.println("date = " + date);

        System.out.println("date.with(TemporalAdjusters.firstDayOfMonth()) = " + date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("date.withDayOfMonth(1) = " + date.withDayOfMonth(1));
        System.out.println("date.with(TemporalAdjusters.lastDayOfMonth()) = " + date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("date.plusDays(1) = " + date.plusDays(1));
        System.out.println("date.plus(1, ChronoUnit.DAYS) = " + date.plus(1, ChronoUnit.DAYS));
        System.out.println("date.minusDays(1) = " + date.minusDays(1));
        System.out.println("----------------");

        //生日检查  用户的生日为1990-02-04
        LocalDate birthday = LocalDate.of(1990, 2, 4);
        MonthDay birthdayMd = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay today = MonthDay.from(LocalDate.of(2020, 2, 4));
        System.out.println("today.equals(birthdayMd) = " + today.equals(birthdayMd));
        System.out.println("------------");

        System.out.println("LocalTime.now() = " + LocalTime.now());
        System.out.println("LocalTime.now().withNano(0) = " + LocalTime.now().withNano(0));
        System.out.println("------");


        //比较两个日期之前时间差
        LocalDate today2 = LocalDate.now();
        LocalDate specifyDate = LocalDate.of(2015, 10, 2);
        Period period = Period.between(specifyDate, today2);
        System.out.println("period.getYears() = " + period.getYears());
        System.out.println("period.getMonths() = " + period.getMonths());
        System.out.println("period.getDays() = " + period.getDays());
        System.out.println("specifyDate.until(today2,ChronoUnit.MONTHS) = " + specifyDate.until(today2, ChronoUnit.MONTHS));
        System.out.println("specifyDate.until(today2,ChronoUnit.DAYS) = " + specifyDate.until(today2, ChronoUnit.DAYS));

        System.out.println("today2.format(DateTimeFormatter.ISO_DATE) = " + today2.format(DateTimeFormatter.ISO_DATE));
        System.out.println("today2.format(DateTimeFormatter.BASIC_ISO_DATE) = " + today2.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println("-----------");

        System.out.println("LocalDate.parse(specifyDate2,DateTimeFormatter.BASIC_ISO_DATE) = " + LocalDate.parse("20151011", DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println("today2.format(DateTimeFormatter.ofPattern(\"yyyy MM dd\")) = " + today2.format(DateTimeFormatter.ofPattern("yyyy MM dd")));
        System.out.println("DateTimeFormatter.ofPattern(\"yyyy MM dd\").format(LocalDate.now()) = " + DateTimeFormatter.ofPattern("yyyy MM dd").format(LocalDate.now()));
        System.out.println("------------");

        System.out.println("Date.from(Instant.now()) = " + Date.from(Instant.now()));
        System.out.println("Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()) = " + Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

        System.out.println("new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() = " + new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }
}
