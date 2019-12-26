package top.richardhao.lean.test.base.thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemos implements Runnable{
    
    @Override
    public void run() {
        try{
            while(true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(20000);
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemos());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All Daemons started");
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
