package top.richardhao.lean.test.base.thread;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedDiningPhilosopher {
    public static void main(String[] args) throws InterruptedException {
        int ponder, size, timeout;
        ExecutorService exec = Executors.newCachedThreadPool();
        Scanner in = new Scanner(System.in);
        ponder = in.nextInt();
        size = in.nextInt();
        timeout = in.nextInt();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size - 1; i++) {
            exec.execute(new Philosopher(sticks[i], sticks[i + 1], i, ponder));
        }
        exec.execute(new Philosopher(sticks[0] , sticks[size - 1], size - 1, ponder));
        TimeUnit.SECONDS.sleep(timeout);
        exec.shutdownNow();
    }
}
