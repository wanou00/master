package com.demo.mutilThread.ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Guangtao Zhou on 8/9/2016.
 */
public class CallableAndFuture {
	public static void main(String[] args) {
		//ʹ��Future�����յ����̵߳ķ��ؽ��
		ExecutorService threadPool = Executors.newSingleThreadExecutor();

		Future future = threadPool.submit(new Callable<String>() {
			public String call() throws Exception {
				Thread.sleep(1000);
				return "Hello";
			}
		});

		try {
			//Future�������ý��ܽ���ĵȴ�ʱ�䣬����ʱ���ܳ�TimeoutException
			System.out.println("result: " + future.get(5, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

		threadPool.shutdown();

		//ʹ��CompletionService�����ն���̵߳ķ��ؽ��
		ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
		CompletionService completionService = new ExecutorCompletionService(threadPool2);

		for (int i = 0; i <10; i ++) {
			final int finalI = i;
			completionService.submit(new Callable<Integer>() {
				public Integer call() throws Exception {
					Thread.sleep(1000);
					return finalI;
				}
			});
		}

		for (int i = 0; i < 10; i ++) {
			try {
				System.out.println("result: " + completionService.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		threadPool2.shutdown();
	}
}
