package test5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        supplement5_1();
        supplement5_2();
    }

    public static void supplement5_1() throws Exception {
        System.out.println("请输入单链表中的10个结点值:");
        NodeList L = new NodeList(10, true);
        System.out.println("删除重复结点前单链表中的各个结点值为:");
        L.display();
        removeRepeatElem(L);
        System.out.println("删除重复结点后单链表中的各个结点值为:");
        L.display();

    }

    private static void removeRepeatElem(NodeList L) throws Exception {
        Node p = L.head.next, q;
        while (p != null) {
            int order = L.indexOf(p.data);
            q = p.next;
            while (q != null) {
                if ((p.data).equals(q.data)) {
                    L.remove(order + 1);
                } else {
                    order++;
                }
                q = q.next;
            }
            p = p.next;

        }
    }

    public static void supplement5_2() throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int m = 0, n = 0;

            System.out.println("请输入LA中结点的个数:");
            m = sc.nextInt();

            System.out.println("请按非递减的方式输入" + "m" + "个数字：");
            NodeList LA = new NodeList(m, true);
            System.out.println("请输入LB中结点的个数:");
            n = sc.nextInt();

            System.out.println("请按非递减的方式输入" + n + "个数字：");
            NodeList LB = new NodeList(n, true);
            System.out.println("将单链表LA和LB归并后,新的单链表LA中的各个数据元素:");

            mergeList(LA, LB).display();
        }
    }

    private static NodeList mergeList(NodeList LA, NodeList LB) {
        Node pa = LA.head.next;
        Node pb = LB.head.next;
        Node pc = LA.head;
        Integer da, db;

        while (pa != null && pb != null) {
            da = Integer.valueOf(pa.data.toString());
            db = Integer.valueOf(pb.data.toString());
            if (da <= db) {
                pc.next = pa;
                pc = pa;
                pa = pa.next;
            } else {
                pc.next = pb;
                pc = pb;
                pb = pb.next;
            }
        }

        pc.next = (pa != null ? pa : pb);
        return LA;
    }

}

// TODO:实验五补充题
