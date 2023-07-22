import homework1.superArray.SuperArray;

/**
 * 使用 “队列” 实现 二叉树的 层次遍历
 *
 * “队列”：是一种 "先进先出“ 的特殊数据结构
 * 这里使用 day18/generic_supper_array/SuperArray （改造过后的超级数组）来模仿队列
 */
public class QueueBinaryTree {
    public static void main(String[] args) {
        RecursiveBinatyTree.Node root = RecursiveBinatyTree.root;
        SuperArray<RecursiveBinatyTree.Node> nodeSuperArray = new SuperArray<>();
        nodeSuperArray.addToHead(root);
        while (nodeSuperArray.getSize() > 0){
            RecursiveBinatyTree.Node node = nodeSuperArray.seek(nodeSuperArray.getSize() - 1);
            nodeSuperArray.delete(nodeSuperArray.getSize() - 1);
            System.out.println(node.data);
            if(node.left != null) {
                nodeSuperArray.addToHead(node.left);
            }
            if(node.right != null){
                nodeSuperArray.addToHead(node.right);
            }
        }
    }
}
