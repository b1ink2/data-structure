package test10;


/**
 * BiTree
 */
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
        if(treeNode != null) {
            System.out.print(treeNode.data);
            preRootTraverse(treeNode.lchild);
            preRootTraverse(treeNode.rchild);
        }
    }

    // 中序遍历
    public void inRootTraverse(BiTreeNode treeNode) {
        if(treeNode != null) {
            inRootTraverse(treeNode.lchild);
            System.out.print(treeNode.data);
            inRootTraverse(treeNode.rchild);
        }
    }

    // 后序遍历
    public void postRootTraverse(BiTreeNode treeNode) {
        if(treeNode != null) {
            postRootTraverse(treeNode.lchild);
            postRootTraverse(treeNode.rchild);
            System.out.print(treeNode.data);
        }
    }

    // 查找节点
    public BiTreeNode searchNTreeNode(BiTreeNode treeNode, Object x) {
        if(treeNode != null){
            if(treeNode.data.equals(x)){
                return treeNode;
            } else {
                BiTreeNode lresult = searchNTreeNode(treeNode.lchild, x);
                return lresult != null ? lresult : searchNTreeNode(treeNode.rchild, x);
            }
        }
    }

    // 计算节点个数
    public int countNode(BiTreeNode treeNode) {

    }

    public int getDepth(BiTreeNode trNode) {
        
    }
    
    public boolean isEqual(BiTreeNode T1, BiTreeNode T2) {
        
    }
    
    // 非递归遍历
    
    // 通过先序中序遍历列表建立二叉树
    
    // 通过后序中序遍历列表建立二叉树
    
    // 二叉树层次遍历

}