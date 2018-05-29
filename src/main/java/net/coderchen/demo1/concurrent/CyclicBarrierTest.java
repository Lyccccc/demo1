package net.coderchen.demo1.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Liuyuchen on 2018/04/25.
 */
public class CyclicBarrierTest {


    public static void main(String[] args) {
        //假设旅行团里有20个人
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11);
        Random random = new Random();
        //一共5个景点
        for (int spot = 0; spot < 5; spot++) {
            //每个人视为一个线程，游览该景点
            for (int person = 0; person < 10; person++) {
                int finalSpot = spot;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("正在游览景点" + finalSpot);
                        try {
                            Thread.sleep(random.nextInt(10));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("已游览完景点" + finalSpot);
                        try {
                            //每个人游览完该景点，开始等待
                            cyclicBarrier.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            try {
                //所有人都已经游览完该景点，继续游览下一景点
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
