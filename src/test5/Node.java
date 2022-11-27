package test5;

public class Node {
    // 成员变量
    public Object data;
    public Node next;
    
    // 构造方法1
    public Node() {
        this(null, null);
    }

    // 构造方法2
    public Node(Object data) {
        this(data,null);
    }
    
    // 构造方法3
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
