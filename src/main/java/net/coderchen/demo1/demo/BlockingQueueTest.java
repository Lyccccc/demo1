package net.coderchen.demo1.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Liuyuchen on 2018/01/25.
 */
public class BlockingQueueTest {
    private static BlockingQueue<Integer> BLOCKING_QUEUE = new ArrayBlockingQueue<Integer>(10);
    private static Random random = new Random();

    public static void main(String[] args) {
        //生产者线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count++ < 100){
                    int i = random.nextInt(10000);
                    try {
                        BLOCKING_QUEUE.put(i);
                        System.out.println("生产了" + i + "并放入队列中");
                        System.out.println("生产者线程-队列剩余个数：" + BLOCKING_QUEUE.size());
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //消费者线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        int i = BLOCKING_QUEUE.take();
                        System.out.println("消费了" + i);
                        System.out.println("消费者线程-队列剩余个数：" + BLOCKING_QUEUE.size());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
