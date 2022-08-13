package com.practice;

import java.util.LinkedList;
import java.util.Queue;

public class PrCo {
    public static void main(String[] args) {
        Queue<String> stringQueue = new LinkedList<>();
        MyProducer prod = new MyProducer(stringQueue, 1000);
        MyConsumer cons = new MyConsumer(stringQueue, 1100);
        Thread prodThread = new Thread(prod);
        Thread consThread = new Thread(cons);
        prodThread.start();
        consThread.start();
    }
}

class MyConsumer implements Runnable {
    private Queue<String> stringQueue;

    private long consumeSpeed;

    public MyConsumer(Queue<String> stringQueue, long consumeSpeed) {
        this.stringQueue = stringQueue;
        this.consumeSpeed = consumeSpeed;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (stringQueue) {
                while (stringQueue.isEmpty()) {
                    System.out.println("consumer waiting");
                    try {
                        stringQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(stringQueue.poll());
                try {
                    Thread.sleep(consumeSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stringQueue.notifyAll();
            }
        }

    }
}

class MyProducer implements Runnable {

    private Queue<String> stringQueue;

    private long produceSpeed;

    private int i;

    public MyProducer(Queue<String> stringQueue, long produceSpeed) {
        this.stringQueue = stringQueue;
        this.produceSpeed = produceSpeed;
        this.i = 0;
    }

    @Override
    public void run() {
        while (i < 100) {
            synchronized (stringQueue) {
                while (stringQueue.size() > 5) {
                    System.out.println("waiting");
                    try {
                        stringQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stringQueue.offer("string " + i);
                System.out.println("offered string " + i++);
                try {
                    Thread.sleep(produceSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stringQueue.notifyAll();
            }
        }
    }
}