package com.personal.thread;

public class ThreadedJob2 extends Thread{
	public void run() {
		task();
	}

	public  void task() {
		synchronized (ThreadConstants.commonLock) {
			while (ThreadConstants.flag == true) {
				try {
					System.out.println("Job2" + Thread.currentThread().getName()  + "-" + "waiting");
					ThreadConstants.commonLock.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			for(int i=0; i<5; i++ ) {
				System.out.println("Job2 -" + Thread.currentThread().getName()  + "-"+i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			ThreadConstants.flag = true;
			ThreadConstants.commonLock.notify();
		}
	}
}
