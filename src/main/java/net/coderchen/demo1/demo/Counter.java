package net.coderchen.demo1.demo;

/**
 * Created by Liuyuchen on 2018/03/13.
 */
public class Counter {
    private static int sum = 0;

    public static void main(String[] args) {
        //开启10个线程，每个线程分别对sum进行1000次+1操作
        for(int i = 0 ; i < 10 ; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0 ; j < 1000 ; j++){
                        sum++;
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //输出多少？
        System.out.println(sum);
    }
}
