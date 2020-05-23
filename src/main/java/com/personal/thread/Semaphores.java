package com.personal.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Semaphores {
	
	public static void main(String[] args) {
		BlockingQueue<Runnable> q = new ArrayBlockingQueue<Runnable>(100);
		Semaphore semaphore = new Semaphore(3);
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 30, TimeUnit.SECONDS, q );
		for(int i = 0; i < 100; i++) {
			tpe.execute(new MyTask(semaphore, i));
		}
		tpe.shutdown();
	}

	private static class MyTask implements Runnable {
		private Semaphore semaphore;
		private int data;

		public MyTask(Semaphore semaphore, int data) {
			this.semaphore = semaphore;
			this.data = data;
		}

		@Override
		public void run() {
			System.out.println(this.data + "," + Thread.currentThread().getName() + "," + semaphore.availablePermits());
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.data + "," + "sleeping for 200ms and exiting ");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			semaphore.release();

		}

	}

}



