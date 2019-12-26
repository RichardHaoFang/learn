package top.richardhao.lean.test.base.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ManyTimers {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(18);
        int n = 100;
        for (int i = 0; i < n; i++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis());                }

            },n - i);
        }
//        TimeUnit.MICROSECONDS.sleep(2*n);
//        System.exit(0);
    }
}
