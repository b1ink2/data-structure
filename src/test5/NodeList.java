package test5;

import java.util.Scanner;

public class NodeList {
    Node head;

    public NodeList() {
        head = new Node();
    }

    public NodeList(int n, boolean Order) throws Exception {
        this();
        if (Order) {
            create1(n);
        } else {
            create2(n);
        }
    }

    public void insert(int i, Object x) throws Exception {
        Node p = head;
        int j = 0;
        while (p != null && j < i) {
            p = p.next;
            ++j;
        }
        if (j > i || p == null)
            throw new Exception("插入位置错误");
        Node s = new Node(x);
        s.next = p.next;
        p.next = s;
    }

    public void create1(int n) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            for (int j = 0; j < n; j++) {
                insert(j, sc.next());
            }
        }
    }

    public void create2(int n) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            for (int j = 0; j < n; j++) {
                insert(length(), sc.next());
            }
        }
    }

    public void clear() {
        head.data = null;
        head.next = null;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public int length() {
        Node p = head;
        int length = 0;

        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    public Object get(int i) throws Exception {
        Node p = head;
        int j = 0;
        while (p != null && j < i) {
            p = p.next;
            j++;
        }

        if (j > i || p == null) {
            throw new Exception("第" + i + "个元素不存在");
        }

        return p.data;
    }

    public void remove(int i) throws Exception {
        Node p = head;
        int j = 0;
        while (p.next != null && j < i) {
            p = p.next;
            ++j;
        }
        if (j > i || p.next == null) {
            throw new Exception("删除位置错误");
        }
        p.next = p.next.next;
    }

    public int indexOf(Object x) {
        Node p = head.next;
        int j = 0;
        while (p != null && !p.data.equals(x)) {
            p = p.next;
            ++j;
        }
        if (p != null)
            return j;
        else
            return -1;
    }

    public void display() {
        Node node = head.next;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

    }
}
