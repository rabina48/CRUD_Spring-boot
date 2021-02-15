package com.client.executorsDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;


public class CallableDemo {

    public static void main(String[] args) throws ExecutionException {
        //this is creating a pool
        ExecutorService executor = (ExecutorService) Executors.newFixedThreadPool(2);
        List<Future> allfuture = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            //submit the task for future

            Future<Integer> futures = executor.submit(new Task());
            allfuture.add(futures);
        }

        for (int i = 0; i < 10; i++) {
            Future<Integer> future = allfuture.get(i);
            try {
                Integer result = future.get();// block until it return the val
                //System.out.println("Thread:------" + Thread.currentThread().getName());
                System.out.println("Result of future " +i+ " =  " + result);
                System.out.println("--------------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


//        Future<Integer> futures = executor.submit(new Task());
//        Integer result = futures.get();
//
//        System.out.println("Thread:------" + Thread.currentThread().getName());
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws InterruptedException {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}
