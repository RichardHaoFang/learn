package top.richardhao.lean.test.base.thread;

import java.io.IOException;

public class ResponsiveUI extends Thread{

    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
       while(true)
           d = d + (Math.PI + Math.E)/d;
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}

