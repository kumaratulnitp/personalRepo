package com.personal.thread;

public class ThreadedJob extends Thread{

	public void run() {
		task();
	}

	public synchronized void task() {
		synchronized (ThreadConstants.commonLock) {
			
		
		while (ThreadConstants.flag == false) {
			try {
				System.out.println(Thread.currentThread().getName()  + "-" + "waiting");
				ThreadConstants.commonLock.wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}	
			System.out.println("kkk");

		}
		for(int j = 0; j< 10; j++) {
			System.out.println("Job1 " + Thread.currentThread().getName()  + "-"+ j);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ThreadConstants.flag = false;
		
		ThreadConstants.commonLock.notifyAll();
		System.out.println("thread run complete" + ThreadConstants.flag);
		}
	}
	
}
