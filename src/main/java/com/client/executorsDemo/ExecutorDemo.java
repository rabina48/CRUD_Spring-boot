package com.client.executorsDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

    public static void main(String[] args) {


       ExecutorService executor = (ExecutorService) Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            //Thread thread = new Thread(new Task());
           // thread.start();
            executor.execute(new Task());

        }

        System.out.println("Thread:" + Thread.currentThread().getName());

    }

    static  class  Task implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread:" + Thread.currentThread().getName());
        }
    }
}
