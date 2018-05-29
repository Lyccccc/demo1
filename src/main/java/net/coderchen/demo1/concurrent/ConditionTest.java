package net.coderchen.demo1.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Liuyuchen on 2018/05/22.
 */
public class ConditionTest {
    public static void main(String[] args) throws Exception {
        //生产者线程
        Thread add1 = new Thread(new AddThread());
        Thread add2 = new Thread(new AddThread());
        Thread add3 = new Thread(new AddThread());
        Thread add4 = new Thread(new AddThread());

        //消费者线程
        Thread sub1 = new Thread(new SubThread());
        Thread sub2 = new Thread(new SubThread());
        Thread sub3 = new Thread(new SubThread());
        Thread sub4 = new Thread(new SubThread());

        add1.start();
        add2.start();
        add3.start();
        add4.start();
        sub1.start();
        sub2.start();
        sub3.start();
        sub4.start();
    }

    static class Task{
        /**
         * 产品列表
         */
        private static List<String> list = new LinkedList<String>();
        private static Lock lock = new ReentrantLock();
        private static Condition addCondition = lock.newCondition();
        private static Condition subCondition = lock.newCondition();
        private static int i = 0;

        public static void add() throws InterruptedException {
            while(true){
                lock.lock();
                try{
                    //队列已满，生产者wait
                    while(list.size() == 10){
                        System.out.println(Thread.currentThread().getName() + "-队列已满！");
                        addCondition.await();
                        System.out.println(Thread.currentThread().getName() + "-已被唤醒！");
                    }
                    String str = "newItem-" + i++;
                    System.out.println(Thread.currentThread().getName() + "-added:" + str);
                    list.add(str);
                    //通知消费者消费
                    subCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        }

        public static void sub() throws InterruptedException {
            while(true){
                lock.lock();
                try{
                    //队列为空，消费者wait
                    while(list.isEmpty()){
                        System.out.println(Thread.currentThread().getName() + "-队列为空！");
                        subCondition.await();
                        System.out.println(Thread.currentThread().getName() + "-已被唤醒！");
                    }
                    System.out.println(Thread.currentThread().getName() + "-deleted:" + list.get(0));
                    list.remove(list.get(0));
                    i--;
                    //通知生产者生产
                    addCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class AddThread implements Runnable{

        @Override
        public void run() {
            try {
                Task.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class SubThread implements Runnable{

        @Override
        public void run() {
            try {
                Task.sub();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
