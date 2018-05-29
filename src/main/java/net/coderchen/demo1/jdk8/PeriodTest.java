package net.coderchen.demo1.jdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by Liuyuchen on 2018/05/22.
 */
public class PeriodTest {
    public static void main(String[] args) {
        LocalDate initialDate = LocalDate.parse("2017-07-20");
        LocalDate finalDate   = initialDate.plus(Period.ofDays(5));
        System.out.println("初始化日期: " + initialDate);
        System.out.println("加日期之后: " + finalDate);
        long between = ChronoUnit.DAYS.between(initialDate, finalDate);
        System.out.println("差距天数: " + between);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime);

    }
}
