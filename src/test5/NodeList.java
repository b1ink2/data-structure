
public class NodeList {
    private Object data;
    private NodeList next;

    public NodeList() {
        this.data = null;
        this.next = null;
    }

    public NodeList(Object data) {
        this.data = data;
        this.next = null;
    }

    public NodeList(Integer data, NodeList nodeList) {
        this.data = data;
        this.next = nodeList;
    }

    public void clear() {
        this.data = null;
        this.next = null;
    }

    public boolean isEmpty() {
        if (this.next == null && this.data == null) {
            return true;
        } else {
            return false;
        }
    }

    public int length() {
        NodeList nodeList = new NodeList();
        int length = 0;
        do {
            nodeList = this.next;
            length++;
        } while (!nodeList.isEmpty());
        return length;
    }

    public Object get(int i) throws Exception {
        NodeList p = this.next;
        int j = 0;
        while (!p.isEmpty() && j < i) {
            p = p.next;
            ++j;
        }

        if (j > i || p.isEmpty()) {
            throw new Exception("第" + i + "个元素不存在");
        }

        return p.data;
    }

    public void insert(int i, Object x) throws Exception {
        NodeList p = this.next;
        int j = 0;
        while (!p.isEmpty() && j < i) {
            p = p.next;
            ++j;
        }
        if (j > i || p.isEmpty())
            throw new Exception("插入位置错误");
        NodeList s = new NodeList(x);
        s.next = p.next;
        p.next = s;
    }

    public void remove(int i) throws Exception {
        NodeList p = this.next;
        int j = 0;
        while(!p.isEmpty() && j<i) {
            p = p.next;
            ++j;
        }
        if (j>i || p.isEmpty()) {
            throw new Exception("删除位置错误");
        }
        p.next=p.next.next;
    }

    public int indexOf(Object x) {
        NodeList p = this.next;
        int j=0;
        while(!p.isEmpty()&&!p.data.equals(x)) {
            p=p.next;
            ++j;
        }
        if(!p.isEmpty())
            return j;
        else
            return -1;
    }
}
