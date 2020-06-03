package com.personal.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Executor e = Executors.newFixedThreadPool(5);
		e.execute(() -> {
			System.out.println("55");
		});
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		Future<String> returnString = es.submit(() -> {
			return "atul";
		});
		
		
		System.out.println(returnString.get());
	}
	
	

}
