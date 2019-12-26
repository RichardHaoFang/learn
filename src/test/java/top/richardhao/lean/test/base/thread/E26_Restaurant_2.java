package top.richardhao.lean.test.base.thread;

import org.junit.AfterClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class E26_Restaurant_2 {

    public static void main(String[] args) {
        new Restaurant2();
    }
}


class WaitPerson2 implements Runnable {
    private Restaurant2 restaurant;
    boolean notified;

    public WaitPerson2(Restaurant2 restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("WaitPerson got " + restaurant.meal);
                synchronized (restaurant.busyBoy) {
                    restaurant.busyBoy.notified = true;
                    restaurant.busyBoy.meal = restaurant.meal;
                    restaurant.busyBoy.notifyAll();

                }
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
                synchronized (this) {
                    if (!notified) {
                        wait();
                    }
                    notified = false;
                }
            }
        }catch (InterruptedException interruptedException) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

class BusyBoy implements Runnable {
    private Restaurant2 restaurant;
    boolean notified;
    volatile Meal meal;

    public BusyBoy(Restaurant2 restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized (this) {
                    if(!notified) {
                        wait();
                    }
                    notified = false;
                }
                System.out.println("Busy Boy Cleaned up " + meal);
                synchronized (restaurant.waitPerson) {
                    restaurant.waitPerson.notified = true;
                    restaurant.waitPerson.notifyAll();
                }
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("BusyBoy interrupted");
        }
    }
}

class Chef2 implements Runnable{
    private Restaurant2 restaurant;

    private int count = 0;
    public Chef2(Restaurant2 restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if(++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException interruptionException) {
            System.out.println("Chef interrupted");
        }
    }
}

class Restaurant2 {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson2 waitPerson = new WaitPerson2(this);
    BusyBoy busyBoy = new BusyBoy(this);
    Chef2 chef = new Chef2(this);

    public Restaurant2() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busyBoy);
    }
}