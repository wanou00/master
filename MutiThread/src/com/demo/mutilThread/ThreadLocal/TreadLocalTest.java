package com.demo.mutilThread.ThreadLocal;

/**
 * Created by Guangtao Zhou on 8/9/2016.
 */
public class TreadLocalTest {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					MyThreadScopeData data = MyThreadScopeData.getInstance();
					System.out.println(Thread.currentThread().getName() + " : " + data);
				}
			}).start();
		}
	}

	static class MyThreadScopeData {
		private static ThreadLocal<MyThreadScopeData> tl = new ThreadLocal<MyThreadScopeData>();

		private MyThreadScopeData() {}

		public static synchronized MyThreadScopeData getInstance() {
			MyThreadScopeData myThreadScopeData = tl.get();
			if (myThreadScopeData == null) {
				myThreadScopeData = new MyThreadScopeData();
				tl.set(myThreadScopeData);
			}
			return myThreadScopeData;
		}
	}

}
