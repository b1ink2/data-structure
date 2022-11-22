package test13;

public class ArcNode {
    public int adjVex;
    public int value;
    public ArcNode nextNode;

    public ArcNode() {
        this(-1, 0, null);
    }
    
    public ArcNode(int adjVex, int value) {
        this(adjVex, value, null);
    }
    
    public ArcNode(int adjVex, int value, ArcNode nextNode) {
        this.value = value;
        this.adjVex = adjVex;
        this.nextNode = nextNode;
    }
}
