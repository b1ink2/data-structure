package test7;

public interface IQueue {
    public void clear();

    public boolean isEmpty();

    public int length();

    public Object peak();

    public void offer(Object x) throws Exception;

    public Object poll();
}
