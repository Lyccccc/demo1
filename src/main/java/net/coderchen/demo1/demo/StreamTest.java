package net.coderchen.demo1.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Liuyuchen on 2018/01/24.
 */
public class StreamTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        Stream<String> stream = list.stream();

        String[] names = new String[]{"zhangsan", "lisi", "wangwu"};
        Stream<String> stream = Arrays.stream(names);

//        Stream<String> stream = Stream.of("chaimm","peter","john");

//        try(Stream lines = Files.lines(Paths.get("D:\\a.txt"), Charset.defaultCharset())){
//            //可对lines做一些操作
//        }catch(IOException e){
//
//        }
    }
}
