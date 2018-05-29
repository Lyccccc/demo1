package net.coderchen.demo1.jdk8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Liuyuchen on 2018/05/22.
 */
public class LocalDateTimeTest {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.parse("2018-05-22 10:41:35", DATE_TIME_FORMATTER);
        System.out.println(localDateTime1.format(DATE_TIME_FORMATTER));
    }
}
