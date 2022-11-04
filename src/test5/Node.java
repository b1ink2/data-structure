public class Node {
    public Object data;
    public Node next;
    
    public Node(){
        Node(null, null);
    }
    
    public Node(Object data){
        Node(data, null);
    }
    
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
