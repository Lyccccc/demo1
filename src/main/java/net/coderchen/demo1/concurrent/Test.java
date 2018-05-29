package net.coderchen.demo1.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 出单测试类，注意地址
 * 生产和测试
 * @author Administrator
 *
 */
public class Test {
	private static final int THREAD_NUM = 100;
	private static int count = 0;
	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_NUM + 1);

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < THREAD_NUM; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (Test.class){
						count++;
						try {
							cyclicBarrier.await();
							System.out.println("count: " + count);
						} catch (InterruptedException e) {
							e.printStackTrace();
						} catch (BrokenBarrierException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
