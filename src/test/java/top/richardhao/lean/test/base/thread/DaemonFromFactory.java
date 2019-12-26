package top.richardhao.lean.test.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+ this);
            } catch (InterruptedException e) {
                System.out.println("Inter");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(17000);
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFromFactory());
        }
        System.out.println("All Daemons Started");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        }).start();
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
