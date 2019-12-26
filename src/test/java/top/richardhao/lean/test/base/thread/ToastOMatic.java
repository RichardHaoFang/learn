package top.richardhao.lean.test.base.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(18);
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                toBeBufferedQueue = new ToastQueue(),
                jammeredQueue = new ToastQueue(),
                toBeJammeredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Alternator(dryQueue,toBeBufferedQueue, toBeJammeredQueue));
        executorService.execute(new Butterer(toBeBufferedQueue, butteredQueue));
        executorService.execute(new Jammer(toBeJammeredQueue, jammeredQueue));
        executorService.execute(new Merge(butteredQueue, jammeredQueue, toBeBufferedQueue, toBeJammeredQueue, finishedQueue));
        executorService.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

class Toast {
    public enum Status {DRY, BUTTERED, JAMMED, READY {
        @Override
        public String toString() {
            return BUTTERED.toString() + "&" + JAMMED.toString();
        }
    }}

    private Status status = Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = (status == Status.DRY) ? Status.BUTTERED : Status.READY;
    }

    public void jam() {
        status = (status == Status.DRY) ? Status.JAMMED : Status.READY;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {
}

class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster Off");
    }
}

class Butterer implements Runnable {
    private ToastQueue inQueue, butterQueue;

    public Butterer(ToastQueue inQueue, ToastQueue butterQueue) {
        this.inQueue = inQueue;
        this.butterQueue = butterQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = inQueue.take();
                t.butter();
                System.out.println(t);
                butterQueue.put(t);
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer Off");
    }
}

class Jammer implements Runnable {
    private ToastQueue inQueue, jammeredQueue;

    public Jammer(ToastQueue inQueue, ToastQueue jammeredQueue) {
        this.inQueue = inQueue;
        this.jammeredQueue = jammeredQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Toast t = inQueue.take();
                t.jam();
                System.out.println(t);
                jammeredQueue.put(t);
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer Off");
    }
}

class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                if(t.getStatus() != Toast.Status.READY) {
                    System.out.println(">>> Error :" + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp " + t);
                }
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater Off");
    }
}

class Alternator implements Runnable {
    private ToastQueue inQueue, out1Queue, out2Queue;
    private boolean outTo2;
    public Alternator(ToastQueue inQueue, ToastQueue out1Queue, ToastQueue out2Queue) {
        this.inQueue = inQueue;
        this.out1Queue = out1Queue;
        this.out2Queue = out2Queue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Toast t = inQueue.take();
                if(!outTo2) {
                    out1Queue.put(t);
                } else {
                    out2Queue.put(t);
                }
                outTo2 = !outTo2;
            }
        } catch (InterruptedException e) {
            System.out.println("Alternator interrupted");
        }
        System.out.println("Alternator Off");
    }
}

class Merge implements Runnable {
    private ToastQueue in1Queue, in2Queue, toBeBufferedQueue, toBeJammeredQueue, finishedQueue;

    public Merge(ToastQueue in1Queue, ToastQueue in2Queue, ToastQueue toBeBufferedQueue, ToastQueue toBeJammeredQueue, ToastQueue finishedQueue) {
        this.in1Queue = in1Queue;
        this.in2Queue = in2Queue;
        this.toBeBufferedQueue = toBeBufferedQueue;
        this.toBeJammeredQueue = toBeJammeredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = null;
                while(t == null) {
                    t = in1Queue.poll(50,TimeUnit.MILLISECONDS);
                    if (t != null) {
                        break;
                    }
                    t = in2Queue.poll(50, TimeUnit.MILLISECONDS);
                }
                switch (t.getStatus()) {
                    case BUTTERED:
                        toBeJammeredQueue.put(t);
                        break;
                    case JAMMED:
                        toBeBufferedQueue.put(t);
                        break;
                    default:finishedQueue.put(t);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Merge Interrupted");
        }
        System.out.println("Merge Off");
    }
}