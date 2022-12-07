package test14;

public class RecordNode {
    public Comparable<Object> key;
    public Object element;

    public RecordNode(Comparable<Object> key) {
        this.key = key;
    }

    public RecordNode(Comparable<Object> key, Object element) {
        this.key = key;
        this.element = element;
    }
}