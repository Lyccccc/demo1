package net.coderchen.demo1.jdk8;

import java.time.LocalTime;

/**
 * Created by Liuyuchen on 2018/05/22.
 */
public class LocalTimeTest {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(10, 35, 01);
        System.out.println(localTime);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX.withNano(0));
    }
}
