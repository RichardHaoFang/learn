package top.richardhao.lean.test.base.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class E24_ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        int producerSleep = 100;
        int consumerSleep = 100;
        FlowQueue<Item> fq = new FlowQueue<Item>(100);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Producer(producerSleep,fq));
        exec.execute(new Consumer(consumerSleep, fq));
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}

class FlowQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private int maxSize;

    public FlowQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void put(T v) throws InterruptedException {
        while (queue.size() >= maxSize) {
            wait();
        }
        queue.offer(v);
        maxSize++;
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T returnVal = queue.poll();
        maxSize--;
        notifyAll();
        return  returnVal;
    }
}

class Item {
    private static int counter;
    private int id = counter++;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                '}';
    }
}

class Producer implements Runnable {
    private int delay;
    private FlowQueue<Item> output;

    public Producer(int delay, FlowQueue<Item> output) {
        this.delay = delay;
        this.output = output;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                output.put(new Item());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException interruptionException) {
                return;
            }
        }
    }
}

class Consumer implements Runnable {
    private int delay;
    private FlowQueue<?> input;

    public Consumer(int delay, FlowQueue<?> input) {
        this.delay = delay;
        this.input = input;
    }

    @Override
    public void run() {
        for(;;) {
            try {
                System.out.println(input.get());
                TimeUnit.MILLISECONDS.sleep(delay);
            }catch (InterruptedException interruptionException) {
                return;
            }
        }
    }
}