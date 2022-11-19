package test11;

public class HuffmanNode {
    public int weight;
    public int flag;
    public HuffmanNode parent;
    public HuffmanNode lchild;
    public HuffmanNode rchild;
    
    public HuffmanNode() {
        this(0);
    }
    
    public HuffmanNode(int weight) {
        this.weight = weight;
        this.flag = 0;
        this.parent = null;
        this.lchild = null;
        this.rchild = null;
    }
}