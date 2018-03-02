package net.coderchen.demo1.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Liuyuchen on 2018/02/08.
 */
public class SynchronizedMapTest {
    private static Map<String,String> map = Collections.synchronizedMap(new HashMap<String, String>());
//    private static Map<String,String> map = new ConcurrentHashMap<String, String>();

    public static void main(String[] args) {
        map.put("name1", "liuyuchen1");
        map.put("name2", "liuyuchen2");
        map.put("name3", "liuyuchen3");
        map.put("name4", "liuyuchen4");
        map.put("name5", "liuyuchen5");
        Thread thread = new Thread(new MyThread());
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            if("liuyuchen3".equals(stringStringEntry.getValue())){
                try {
                    Thread.sleep(500);
                    thread.start();
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(stringStringEntry.getValue());
        }
    }

    static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("mythread");
            map.remove("name5");
            map.remove("name4");
            map.remove("name3");
            map.remove("name2");
            map.remove("name1");
        }
    }

//    private static Map<String, Object> map1 = new HashMap<String, Object>();
//    private static Map<String, Object> map2 = new Hashtable<String, Object>();
//    private static Map<String, Object> map3 = new ConcurrentHashMap<String, Object>();
//    private static Map<String, Object> map4 = Collections.synchronizedMap(new HashMap<String, Object>());
//
//    private static Map<String, Object> map = map4;
//
//    public static void main(String[] args) {
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while (true) {
//                    if (map.size() > 0) {
//                        for (Map.Entry<String, Object> entry : map.entrySet()) {
//                            System.out.println(String.format("%s: %s", entry.getKey(), entry.getValue()));
//                        }
//                        map.clear();
//                    }
//                    try {
//                        Thread.sleep((new Random().nextInt(10) + 1) * 1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//
//                for (int i = 1; i <= 100; i++) {
//                    map.put("key" + i, "value" + i);
//                    try {
//                        Thread.sleep((new Random().nextInt(10) + 1) * 1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//    }
}
