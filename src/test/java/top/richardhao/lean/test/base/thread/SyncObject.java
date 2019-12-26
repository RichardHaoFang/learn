package top.richardhao.lean.test.base.thread;

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ds.f();
            }
        }).start();
        ds.g();
    }
}
