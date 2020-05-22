package com.personal.thread;

import java.util.Queue;

public class Consumer implements Runnable {

	private Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					System.out.println("waiting in consumer");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Integer i = queue.poll();
				System.out.println("fetched value" + i);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				queue.notifyAll();

			}
		}
	}

}
