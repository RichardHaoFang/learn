package top.richardhao.lean.test.base.thread;

public class E02_Fibonacci {
    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++)
            new Thread(new Fibonacci(i)).start();
    }
}
