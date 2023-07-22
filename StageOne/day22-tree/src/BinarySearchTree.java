import javax.swing.tree.TreeNode;

/**
 * 介绍了一种特殊类型的二叉树（二叉查找数），并使执行 查找操作
 */
public class BinarySearchTree {
    /**
     * 二叉树数据结构
     */
    static class TreeNode{
        int data;
        TreeNode lchild;
        TreeNode rchild;

        TreeNode() {}
        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 查找二叉树
     * @param root
     *          待查询的二叉树
     * @param target
     *          目标值
     * @return 没有返回null，有则返回节点
     */
    public static TreeNode searchBinaryTree(TreeNode root, int target){
        if(root == null){ // 树节点不存在，返回
            return null;
        }else if(target == root.data){ // 查找成功
            return root;
        }else if(target < root.data){ // 关键字小于根节点查找左子树
            return searchBinaryTree(root.lchild, target);
        }else{ // 关键字大于根节点查找右子树
            return searchBinaryTree(root.rchild, target);
        }
    }
    public static void main(String[] args) {
        /** 构建一个二叉查找树 */
        TreeNode root = new TreeNode(62);

        TreeNode treeNode1 = new TreeNode(58);
        root.lchild = treeNode1;

        TreeNode treeNode2 = new TreeNode(88);
        root.rchild = treeNode2;

        TreeNode treeNode3 = new TreeNode(47);
        treeNode1.lchild = treeNode3;

        TreeNode treeNode4 = new TreeNode(73);
        treeNode2.lchild = treeNode4;

        TreeNode treeNode5 = new TreeNode   (99);
        treeNode2.rchild = treeNode5;

        TreeNode treeNode6 = new TreeNode(35);
        treeNode3.lchild = treeNode6;

        TreeNode treeNode7 = new TreeNode(51);
        treeNode3.rchild = treeNode7;

        TreeNode treeNode8 = new TreeNode(93);
        treeNode5.lchild = treeNode8;

        TreeNode treeNode9 = new TreeNode(37);
        treeNode6.rchild = treeNode9;

        TreeNode treeNode = searchBinaryTree(root, 93);
        System.out.println(treeNode == null ?"找不到目标值":treeNode.data);

    }

}
