package com.demo.mutilThread.shareData;

/**
 * Created by Guangtao Zhou on 8/9/2016.
 */
public class MutiThreadShareData {
	public static void main(String args[]) {
		final ShareData1 data1 = new ShareData1();

		new Thread(new Runnable() {
			public void run() {
//				data1.decrement();
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
//				data1.increment();
			}
		}).start();
	}

	static class ShareData1 implements Runnable {

		private int count = 100;

		public void run() {
			while(true) {
				if (count > 0) count--;
				else return;
			}
		}
	}

}
