public class SqQueue implements IQueue {
    private Object[] queueElem;
    private int front;
    private int rear;

    public SqQueue(int size) {
        this.front = 0;
        this.rear = 0;
        this.queueElem = new Object[size];
    }

    @Override
    public void clear() {
        front = 0;
        rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int length() {
        int l = (rear - front + queueElem.length) % queueElem.length;
        return l;
    }

    @Override
    public Object peek() {
        if (front == rear)
            return null;
        else
            return queueElem[front];
    }

    @Override
    public void offer(Object x) throws Exception {
        if ((rear + 1) % queueElem.length == front)
            throw new Exception("queue over flow");
        else {
            queueElem[rear] = x;
            rear = (rear + 1) % queueElem.length;
        }

    }

    @Override
    public Object poll() {
        if (front == rear)
            return null;
        else {
            Object x = queueElem[front];
            front = (front + 1) % queueElem.length;
            return x;
        }
    }
}
