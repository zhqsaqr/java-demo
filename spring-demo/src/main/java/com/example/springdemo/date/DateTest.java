package com.example.springdemo.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DateTest {

    private static DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        LocalDate formatDate = LocalDate.of(2023, 2, 5); // 自定义
        LocalDate today = LocalDate.now(); // 获取当前日期

        System.out.println(LocalDateTime.now().format(dtf));

        System.out.println("年========="+formatDate.getYear()); //  获取年
        System.out.println("月========="+formatDate.getMonthValue()); //获取月
        System.out.println(formatDate.getMonth()); //  获取月（英文）
        System.out.println("日========="+formatDate.getDayOfMonth()); //获取天
        System.out.println("年的第几天========="+formatDate.getDayOfYear()); //获取今天是全年的第几天
        System.out.println("月的第几天========="+formatDate.getDayOfMonth()); //获取今天是本月的第几天


        String dateStr = formatDate.format(dt);
        System.out.println("时间格式化===时间转字符串=========" + dateStr);
        System.out.println("时间格式化===字符串转时间========="+LocalDate.parse(dateStr));

        System.out.println("昨天==========="+formatDate.minusDays(1));
        System.out.println("明天==========="+formatDate.plusDays(1));
        System.out.println("上周当天==========="+formatDate.minusWeeks(1));
        System.out.println("下周当天==========="+formatDate.plusWeeks(1));
        System.out.println("上月当天==========="+formatDate.minusMonths(1));
        System.out.println("下月当天==========="+formatDate.plusMonths(1));

        System.out.println("本周第一天=========="+formatDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
        System.out.println("本月第一天=========="+formatDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("本年第一天=========="+formatDate.with(TemporalAdjusters.firstDayOfYear()));


        // 判断两个日期前后
        boolean param = formatDate.isBefore(today);
        System.out.println("日期大小比较=================="+param); //true 判断a是否早于b
        // 计算两个日期的间隔天数
        LocalDate start = LocalDate.parse("2019-12-01");
        LocalDate end = LocalDate.parse("2020-02-05");
        long days = start.until(end, ChronoUnit.DAYS);
        System.out.println("间隔天数=======================" + days);

    }

}
