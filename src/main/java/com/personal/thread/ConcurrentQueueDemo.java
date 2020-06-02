package com.personal.thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConcurrentQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new LinkedBlockingDeque<Integer>();
		for(int i=0; i<2; i++) {
			new Thread(new Producer(bq)).start();
		}

		for(int i=0; i<5; i++) {
			new Thread(new Consumer(bq)).start();
		}

	}

	public static class Producer implements Runnable{
		private BlockingQueue<Integer> queue;
		private Random random;

		public Producer(BlockingQueue<Integer> queue) {
			this.queue = queue;
			this.random = new Random();
		}

		@Override
		public void run() {
			for(int i = 0; i < 10; i++) {
				Integer num = random.nextInt();
				try {
					//System.out.println("putting " + num);
					queue.put(num);
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.out.println("Producer exception" + e.getMessage());
				}
			}

		}
	}

	public static class Consumer implements Runnable {

		private BlockingQueue<Integer> queue;
		public Consumer(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while(true) {
				try {
					System.out.println("Last value is " + queue.take());
				} catch (InterruptedException e) {
					System.out.println("Consumer exception" + e.getMessage());
				}
			}

		}

	}
}
