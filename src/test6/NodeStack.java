package test6;
import test5.Node;
public class NodeStack {
    private Node top;
    public void clear() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int length() {
        Node p = top;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        return count;
    }

    public Object peek() {
        if(!isEmpty())
            return top.data;
        else
            return null;
    }
    public void push(Object x) {
        Node p = new Node(x, top);
        top = p;
    }

    public Object pop() {
        if(!isEmpty()) {
            Node p = top;
            top = top.next;
            return p.data;
        } else {
            return null;
        }
    }
}
