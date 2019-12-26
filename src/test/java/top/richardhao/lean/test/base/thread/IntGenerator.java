package top.richardhao.lean.test.base.thread;

public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void canceled(){canceled = true;};
    public boolean isCanceled(){return canceled;}
}
