package net.coderchen.demo1.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liuyuchen on 2018/02/02.
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("liuyuchen");
        list.add("helloworld");
        list.add("abc");
        list.forEach(str -> {
            System.out.println(str);
        });
    }
}
