package test5;

import java.util.Scanner;

public class NodeList {
    // 单链表头节点
    Node head;

    // 无参构造 
    public NodeList() {
        head = new Node();
    }

    // 有参构造 ，分为头插法和位插法
    public NodeList(int n, boolean Order) throws Exception {
        this();
        if (Order) {
            create1(n);
        } else {
            create2(n);
        }
    }

    // 插入
    public void insert(int i, Object x) throws Exception {
        /* 寻找第i个节点的前驱
         * 若存在则创建新的节点插入
         * 若不存在则返回报错
         */
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

    // 头插法
    public void create1(int n) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            for (int j = 0; j < n; j++) {
                insert(j, sc.next());
            }
        }
    }

    // 尾插法
    public void create2(int n) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            for (int j = 0; j < n; j++) {
                insert(length(), sc.next());
            }
        }
    }

    // 通过清空head实现清除
    public void clear() {
        head.data = null;
        head.next = null;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 遍历所有节点返回长度
    public int length() {
        Node p = head;
        int length = 0;

        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    // 获取第i个节点
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

    // 删除第i个节点
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

    // 返回节点索引
    public int indexOf(Object x) {
        /* 
         * 通过比较各个节点和x是否相同
         * 有相同返回索引
         * 没有相同返回-1
         */
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

    // 打印链表
    public void display() {
        Node node = head.next;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

    }
}
