package test7;

public class NodeQueue{
    private Node front; // 队首元素
    private Node rear; // 队尾元素

    // 构造器
    // Q

    // 清空队列
    public void clear() {
        this.front = null;
        this.rear = null;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return front == null;
    }

    // 返回长度
    public int length() {
        /*
         * 遍历队列所有元素
         * 每遍历一个计数器就加一
         */
        Node p = front;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    // 返回队尾元素
    public Object peak() {
        if (front != null)
            return front.data;
        else
            return null;
    }

    // 入队
    public void offer(Object x) {
        Node p = new Node(x);
        if (front != null) {
            rear.next = p;
            rear = p;
        } else {
            front = p;
            rear = p;
        }
    }

    // 出队
    public Object poll() {
        if (front != null) {
            Node p = front;
            front = front.next;
            if (p == rear)
                rear = null;
            return p.data;
        } else {
            return null;
        }
    }
}

