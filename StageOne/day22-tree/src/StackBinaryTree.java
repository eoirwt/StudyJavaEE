import java.util.Stack;
/**
 * 使用 “栈” 实现二叉树 先序遍历
 */
public class StackBinaryTree {
    public static void preTraverse(RecursiveBinatyTree.Node root){
        /** Stack 是java提供的一种数据结构，可直接使用 */
        Stack<RecursiveBinatyTree.Node> stack = new Stack<>();
        /** push(): 压栈 */
        stack.push(root);
        while (!stack.isEmpty()){
            /** pop(): 弹栈 */
            RecursiveBinatyTree.Node node = stack.pop();
            System.out.print(node.data + " ");
            /** 一定要确保 右子树 先压入栈，这很关键! */
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }
    public static void main(String[] args) {
        RecursiveBinatyTree.Node root = RecursiveBinatyTree.root;
        /** 使用 “栈” 实现二叉树 先遍历 */
        StackBinaryTree.preTraverse(root);
    }
}
