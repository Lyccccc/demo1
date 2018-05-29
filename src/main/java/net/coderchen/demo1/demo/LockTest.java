package net.coderchen.demo1.demo;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Liuyuchen on 2018/03/05.
 */
public class LockTest implements Runnable{
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        System.out.println("run");
        method1();
    }

    private void method1(){
        lock.lock();
        System.out.println("method1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method2();
        lock.unlock();
    }

    private void method2(){
        lock.lock();
        System.out.println("method2");
        lock.unlock();
    }

    @Test
    public void funTest(){
        LockTest lt = new LockTest();
        new Thread(lt).start();
        new Thread(lt).start();
    }
}
