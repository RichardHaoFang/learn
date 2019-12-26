package top.richardhao.lean.test.base.thread;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadlockingDiningPhilosopher {
    public static void main(String[] args) throws InterruptedException {
        int ponder, size, timeout;
        Scanner in = new Scanner(System.in);
        ponder = in.nextInt();
        size = in.nextInt();
        timeout = in.nextInt();
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(sticks[i], sticks[(i+1)%size], i, ponder));
        }
        TimeUnit.SECONDS.sleep(timeout);
        exec.shutdownNow();
    }
}
