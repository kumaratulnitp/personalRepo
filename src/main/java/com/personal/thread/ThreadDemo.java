package com.personal.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemo implements Runnable{

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());

		ThreadedJob tj1 = new ThreadedJob();
		ThreadedJob2 tj2 = new ThreadedJob2();
		tj1.start();
		tj2.start();
		
		System.out.println("all done");
	}

	@Override
	public void run() {
		try {
			Thread.currentThread().wait();
		} catch (InterruptedException e1) {
			System.out.println("wait exception");
		}
		for(int i = 0; i< 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-"+ i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
