package test7;

public class NodeQueue implements IQueue{
    private Node front;
    private Node rear;
    
    public NodeQueue() {
        this.front = null;
        this.rear = null;
    }
    
    public void clear() {
        this.front = null;
        this.rear = null;
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public int length() {
        Node p = front;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }
    
    public Objectj peak() {
        if (front != null)
            return front.data;
        else
            return null;
    }
    
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
    
    public Object poll() {
        if (front != null) {
            Node p = front;
            front = front.next;
            if (p == rear) 
                rear = null;
            return p;
        } else {
            return null;
        }
    }
}

