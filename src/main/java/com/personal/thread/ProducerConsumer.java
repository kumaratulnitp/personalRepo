package com.personal.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Thread t1 = new Thread(new Producer(queue));
		Thread t2 = new Thread(new Consumer(queue));
		t1.start();
		t2.start();
		
	}

}
