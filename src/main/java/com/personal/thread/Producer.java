package com.personal.thread;

import java.util.Queue;

public class Producer implements Runnable{
	private Queue<Integer> queue;

	public Producer(Queue<Integer> queue) {
		this.queue = queue;
	}

	public void add(Integer i) throws InterruptedException {

		synchronized (queue) {
			while (queue.size() > 5) {
				System.out.println("waiting in producer");
				queue.wait();
			}

			System.out.println("putting value" + i);
			queue.offer(i);
			Thread.sleep(200);
			queue.notifyAll();
		}

	}

	@Override
	public void run() {
		for (int i = 1; i < 20; i++) {
			try {
				add(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
