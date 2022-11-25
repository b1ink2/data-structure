package test10;

import test6.NodeStack;
import test7.NodeQueue;

public class BiTree {

    private BiTreeNode root;

    public BiTree() {
        this.root = null;
    }

    public BiTree(BiTreeNode root) {
        this.root = root;
    }

    // 先序遍历
    public void preRootTraverse(BiTreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.data);
            preRootTraverse(treeNode.lchild);
            preRootTraverse(treeNode.rchild);
        }
    }

    // 中序遍历
    public void inRootTraverse(BiTreeNode treeNode) {
        if (treeNode != null) {
            inRootTraverse(treeNode.lchild);
            System.out.print(treeNode.data);
            inRootTraverse(treeNode.rchild);
        }
    }

    // 后序遍历
    public void postRootTraverse(BiTreeNode treeNode) {
        if (treeNode != null) {
            postRootTraverse(treeNode.lchild);
            postRootTraverse(treeNode.rchild);
            System.out.print(treeNode.data);
        }
    }

    // 查找节点
    public BiTreeNode searchNTreeNode(BiTreeNode treeNode, Object x) {
        if (treeNode != null) {
            if (treeNode.data.equals(x)) {
                return treeNode;
            } else {
                BiTreeNode lresult = searchNTreeNode(treeNode.lchild, x);
                return lresult != null ? lresult : searchNTreeNode(treeNode.rchild, x);
            }
        }
        return null;
    }

    // 计算节点个数
    public int countNode(BiTreeNode treeNode) {
        int count = 0;
        if (treeNode != null) {
            count++;
            count += countNode(treeNode.lchild);
            count += countNode(treeNode.rchild);
        }
        return count;
    }

    public int getDepth(BiTreeNode treeNode) {
        if (treeNode != null) {
            int lDepth = getDepth(treeNode.lchild);
            int rDepth = getDepth(treeNode.rchild);

            return 1 + (lDepth > rDepth ? lDepth : rDepth);
        }

        return 0;
    }

    public boolean isEqual(BiTreeNode T1, BiTreeNode T2) {
        if (T1 == null && T2 == null) {
            return true;
        }
        if (T1 != null && T2 != null)
            if (T1.data.equals(T2.data))
                if (isEqual(T1.lchild, T2.lchild))
                    if (isEqual(T1.rchild, T2.rchild))
                        return true;
        return false;

    }

    // 非递归遍历
    public void preRootTraverse() {
        BiTreeNode T = root;
        if (T != null) {
            NodeStack S = new NodeStack(); // 构造栈
            S.push(T); // 根结点入栈
            while (!S.isEmpty()) {
                T = (BiTreeNode) S.pop();
                System.out.print(T.data);
                while (T != null) {
                    if (T.lchild != null)
                        System.out.print(T.lchild.data);
                    if (T.rchild != null)
                        S.push(T.rchild);
                    T = T.lchild;
                }
            }
        }
    }

    public void inRootTraverse() {
        BiTreeNode T = root;
        if (T != null) {
            NodeStack S = new NodeStack();
            S.push(T);
            while (!S.isEmpty()) {
                while (S.peek() != null)
                    S.push(((BiTreeNode) S.peek()).rchild);
                S.pop();
                if (!S.isEmpty()) {
                    T = (BiTreeNode) S.pop();
                    System.out.print(T.data);
                    S.push(T.rchild);
                }
            }
        }
    }

    public void postRootTraverse() {
        BiTreeNode T = root;
        if (T != null) {
            NodeStack S = new NodeStack();
            S.push(T);
            Boolean flag;
            BiTreeNode p = null;
            while (!S.isEmpty()) {
                while (S.peek() != null)
                    S.push(((BiTreeNode) S.peek()).lchild);
                S.pop();
                while (!S.isEmpty()) {
                    T = (BiTreeNode) S.peek();
                    if (T.rchild == null || T.rchild == p) {
                        System.out.print(T.data);
                        S.pop();
                        p = T;
                        flag = true;
                    } else {
                        S.push(T.rchild);
                        flag = false;
                    }
                    if (!flag)
                        break;
                }
            }
        }
    }

    // 二叉树层次遍历
    public void levelTraverse() {
        BiTreeNode T = root;
        if (T != null) {
            NodeQueue L = new NodeQueue();
            L.offer(T);
            while (!L.isEmpty()) {
                T = (BiTreeNode) L.poll();
                System.out.print(T.data);
                if (T.lchild != null)
                    L.offer(T.lchild);
                if (T.rchild != null)
                    L.offer(T.rchild);
            }
        }
    }

}