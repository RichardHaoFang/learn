package top.richardhao.lean.test.base.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
       lock.lock();
       try {
           ++currentEvenValue;
           Thread.yield();
           ++currentEvenValue;
//           return currentEvenValue;
       } finally {
           lock.unlock();
           return currentEvenValue;
       }
    }

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(19);
        EvenChecker.test(new MutexEvenGenerator());
    }
}
