package top.richardhao.lean.test.base.thread;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class E23_WaxOMatic2 {
    public static void main(String[] args) throws InterruptedException {
        Car2 car = new Car2();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff2(car));
        exec.execute(new WaxOn2(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

class Car2 {
    private boolean waxOn;
    public synchronized void waxed() {
        waxOn = true;
        notify();
    }

    public synchronized void buffered() {
        waxOn = false;
        notify();
    }

    public synchronized void waitForBuffering() throws InterruptedException {
        while(waxOn == true) {
            wait();
        }
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }
}

class WaxOn2 implements Runnable {
    private Car2 car;

    public WaxOn2(Car2 car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffering();
            }
        }catch (InterruptedException interruptedException) {
            System.out.println("Exciting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff2 implements Runnable {
    private Car2 car;

    public WaxOff2(Car2 car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffered();
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Exciting via interrupt");
        }
        System.out.println("Ending Wax Off Task");
    }
}