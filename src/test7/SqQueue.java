package test7;

public class SqQueue {
    private Object[] queueElem;
    private int front;
    private int rear;

    public SqQueue(int size) {
        this.front = 0;
        this.rear = 0;
        this.queueElem = new Object[size];
    }

    public void clear() {
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int length() {
        int l = (rear - front + queueElem.length) % queueElem.length;
        return l;
    }

    public Object peak() {
        if (front == rear)
            return null;
        else
            return queueElem[front];
    }

    public void offer(Object x) throws Exception {
        if ((rear + 1) % queueElem.length == front)
            throw new Exception("queue over flow");
        else {
            queueElem[rear] = x;
            rear = (rear + 1) % queueElem.length;
        }

    }

    public Object poll() {
        if (front == rear)
            return null;
        else {
            Object x = queueElem[front];
            front = (front + 1) % queueElem.length;
            return x;
        }
    }

    public void display() {
        for (Object object : queueElem) {
            System.out.print(object+" ");
        }
    }
}
