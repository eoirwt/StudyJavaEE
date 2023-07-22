package homework1.superLink;

import homework1.Super;

/**
 *
 */
public class SuperLink<T> implements Super<T> {
    // 表示链表头
    SuperLink.Node head;
    int currentIndex = -1;

    public SuperLink() {}

    // 在链表的头部插入节点
    public void addToHead(T data){
        add(0, data);
    }
    // 在链表的尾部插入节点
    public void addToTail(T data){
        add(currentIndex + 1, data);
    }
    // 指定下标index插入节点
    @Override
    public void add(int index, T data) {
        if(head == null) {
            head = new SuperLink.Node(data, null);
        }else {
            if(index == 0){
                head = new SuperLink.Node(data, head);
            }else {
                SuperLink.Node node = head;
                // 通过循环找到下标为 index - 1 的节点
                for (int i=0; i < index - 1; i++){
                    node = node.getNext();
                }
                // 插入的核心
                node.setNext(new SuperLink.Node(data, node.getNext()));
            }
        }
        currentIndex++;
    }

    @Override
    public void delete(int index) {
        if(index == 0){
            head = head.getNext();
        }else {
            // 通过 node 来记录每次循环的节点
            Node node = head;
            // 通过循环找到下标为 index - 1 的节点
            for (int i=0; i < index - 1; i++){
                node = node.getNext();
            }
            // 删除的核心
            node.setNext(node.getNext().getNext());
        }
        currentIndex--;
    }

    @Override
    public void modification(int index, T data) {
        // 通过 node 来记录每次循环的节点
        Node node = head;
        // 通过循环找到下标为 index 的节点
        for (int i=0; i < index; i++){
            node = node.getNext();
        }
        // 改修节点的数据
        node.setData(data);
    }

    @Override
    public T seek(int index) {
        // 通过 node 来记录每次循环的节点
        Node node = head;
        // 通过循环找到下标为 index 的节点
        for (int i=0; i < index; i++){
            node = node.getNext();
        }
        // 返回节点数据
        return (T)node.getData();
    }

    // 获取长度
    @Override
    public int getSize(){
        return this.currentIndex + 1;
    }
    // 打印链表值
    public String linkToString(){
        String result = "[";
        for (int i = 0; i <= currentIndex; i++){
            result += seek(i).toString() + ",";
        }
        result = result.substring(0, result.length()-1) + "]";
        return result;
    }

    static class Node {
        private Object data;
        private Node next;
        public Node(){}
        public Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }
        public void setData(Object data){
            this.data = data;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Object getData(){
            return this.data;
        }
        public Node getNext(){
            return this.next;
        }
    }
}

