package top.richardhao.lean.test.base.thread;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread()+":"+countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true){
            for (int i = 0; i < 10000000; i++) {
                d += (Math.PI+Math.E)/(double)i;
//                if(i%100000 == 0){
//                    Thread.yield();
//                }
            }
            System.out.println(this);
            if(--countDown==0) return;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(20000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
