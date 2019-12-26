package top.richardhao.lean.test.base.thread;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable{
    @Override
    public void run() {
        System.out.println("Start ADaemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This should always run?");
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
//        t.setDaemon(true);
        t.start();
    }
}
