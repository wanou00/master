package com.demo.mutilThread;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Guangtao Zhou on 8/8/2016.
 */
public class MutiThreadTest1 {
	public static void main(String[] args) throws Exception {
		final Map<String, String> map = new Hashtable<String, String>();
		deadLock(map);
	}

	public static void deadLock(final Map<String, String> map) throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					new Thread(new Runnable() {
						public void run() {
							String key = UUID.randomUUID().toString();
							System.out.println(key);
							map.put(key, "");
						}
					}, "ftf" + i).start();
				}
			}
		}, "ftf");
		t.start();
		t.join();
		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start)/1000);
	}

	class Thread1 implements Runnable {
		public void run() {
			try {
				System.out.println("Runnable start...");
				Thread.sleep(5000);
				System.out.println("Runnable end...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class Thread2 extends Thread {
		public void run() {
			try {
				System.out.println("Thread start...");
				Thread.sleep(3000);
				System.out.println("Thread end...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
