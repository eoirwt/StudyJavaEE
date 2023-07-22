/**
 * 使用递归遍历二叉树
 */
public class RecursiveBinatyTree {
    public static Node root;
    static {
        /** 构建一个满二叉树 */
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }
    /** Node 表示二叉树的一个节点 */
    public static class Node {
        Integer data;
        Node left;
        Node right;
        public Node(){}
        public Node(Integer data){
            this.data = data;
        }
    }

    public static void preRecursive(Node node){
        if(node == null) return;
        System.out.print(node.data + " ");
        preRecursive(node.left);
        preRecursive(node.right);
    }
    public static void onRecursive(Node node){
        if(node == null) return;
        onRecursive(node.left);
        System.out.print(node.data + " ");
        onRecursive(node.right);
    }
    public static void hindRecursive(Node node){
        if(node == null) return;
        hindRecursive(node.left);
        hindRecursive(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        /** 前序遍历 二叉树 */
        RecursiveBinatyTree.preRecursive(root); //1 2 4 5 3 6 7

        /** 中序遍历 二叉树*/
//        RecursiveBinatyTree.onRecursive(root); //4 2 5 1 6 3 7

        /** 后序遍历 二叉树 */
//        RecursiveBinatyTree.hindRecursive(root); //4 5 2 6 7 3 1
    }
}
