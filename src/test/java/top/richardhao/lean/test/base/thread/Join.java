package top.richardhao.lean.test.base.thread;


import java.lang.management.ThreadInfo;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(18);
        Sleeper sleepy = new Sleeper("Sleepy", 10000),
                grumpy = new Sleeper("Grumpy", 10000);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("doc", grumpy);
        TimeUnit.SECONDS.sleep(3);
        grumpy.interrupt();
    }
}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted" +
                    "isInterrupted():" + isInterrupted());
            return;
        }
        System.out.println(getName() + " Has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
            System.out.println("shuiyixia");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("xinglw");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}