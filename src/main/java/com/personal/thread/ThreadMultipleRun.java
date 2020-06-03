package com.personal.thread;

public class ThreadMultipleRun {

	public static void main(String[] args) {
		Runnable r = new MyThread();
		Thread t = new Thread(r);
		System.out.println(t.getState());
		t.start();
		System.out.println(t.getState());
		//t.yield();
		System.out.println(t.isAlive());
		System.out.println(t.getState());
		t.run();
		System.out.println(t.isAlive());
		t.run();
		System.out.println(t.isAlive());
		
		/*
		 * There is no guarantee on calling run method again
		 * In case of worker threads, the run method never reaches end, 
		 * instead it keeps waiting for a task to be done via a listener(or flag)
		 * once it does a task, it goes again to same waiting state.
		 */

	}

	public static class MyThread implements Runnable {
		
		@Override
		public void run() {
			System.out.println("called me");
		}
		
	}
}
