package com.demo.mutilThread.ThreadPool;

import java.util.Calendar;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Guangtao Zhou on 8/9/2016.
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
//		ExecutorService threadPool = Executors.newFixedThreadPool(3);
//		ExecutorService threadPool = Executors.newCachedThreadPool();
		/*ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int taskId = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + "is looping of " + j + "for task of " + taskId);
					}
				}
			});
		}
		System.out.println("=============");
		threadPool.shutdown();*/

		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("++++++++" + Calendar.getInstance().getTime());
			}
		}, 5, 1, TimeUnit.SECONDS);
	}
}
