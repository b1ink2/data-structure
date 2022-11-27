package test7;

public class SqQueue {
    private Object[] queueElem; // 队列内元素
    private int front; // 队首元素位置
    private int rear; // 队尾元素位置

    // 构造器
    public SqQueue(int size) {
        this.front = 0;
        this.rear = 0;
        this.queueElem = new Object[size];
    }

    // 清空队列
    public void clear() {
        front = 0;
        rear = 0;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 返回队列元素个数
    public int length() {
        /* 
         * 因为是循环队列
         * 元素个数为索引值的差加队列长度的求模
         * 否则可能为负值出错
         */
        int l = (rear - front + queueElem.length) % queueElem.length;
        return l;
    }

    // 返回队尾元素
    public Object peak() {
        if (front == rear)
            return null;
        else
            return queueElem[front];
    }

    // 入队
    public void offer(Object x) throws Exception {
        if ((rear + 1) % queueElem.length == front)
            throw new Exception("queue over flow");
        else {
            queueElem[rear] = x;
            rear = (rear + 1) % queueElem.length;
        }

    }

    // 出队
    public Object poll() {
        if (front == rear)
            return null;
        else {
            Object x = queueElem[front];
            front = (front + 1) % queueElem.length;
            return x;
        }
    }

    // 遍历元素并打印
    public void display() {
        for (Object object : queueElem) {
            System.out.print(object+" ");
        }
    }
}
