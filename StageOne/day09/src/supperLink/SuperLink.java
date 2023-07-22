package supperLink;

/**
 * ClassName: SuperLink
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/8 9:56
 * @Version 1.0
 */
public class SuperLink {
    // 表示链表头
    Node head;
    int currentIndex = -1;

    //向链表的头部插入节点
/*    public void add(int data){
        if(head == null) {
            head = new Node(data, null);
        }else {
            head = new Node(data, head);
        }
        currentIndex++;
    }*/


    // 指定下标 index 插入节点
   /* public void add(int index, int data){
        // 如果是 0, 直接就可以头插入
        if(index == 0){
            add(data);
        }else {
            Node node = head;
            // 通过循环找到下标为 index - 1 的节点
            for (int i=0; i < index - 1; i++){
                node = node.getNext();
            }
            // 插入的核心
            node.setNext(new Node(data, node.getNext()));
            currentIndex++;
        }
    }*/


    // 在链表的头部插入节点
    public void addToHead(int data){
        add(0, data);
    }
    // 在链表的尾部插入节点
    public void addToTail(int data){
        add(currentIndex + 1, data);
    }
    // 指定下标index插入节点
    public void add(int index, int data){
        if(head == null) {
            head = new Node(data, null);
        }else {
            if(index == 0){
                head = new Node(data, head);
            }else {
                Node node = head;
                // 通过循环找到下标为 index - 1 的节点
                for (int i=0; i < index - 1; i++){
                    node = node.getNext();
                }
                // 插入的核心
                node.setNext(new Node(data, node.getNext()));
            }
        }
        currentIndex++;
    }
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
    public void set(int index, int data){
        // 通过 node 来记录每次循环的节点
        Node node = head;
        // 通过循环找到下标为 index 的节点
        for (int i=0; i < index; i++){
            node = node.getNext();
        }
        // 改修节点的数据
        node.setData(data);
    }
    public int select(int index){
        // 通过 node 来记录每次循环的节点
        Node node = head;
        // 通过循环找到下标为 index 的节点
        for (int i=0; i < index; i++){
            node = node.getNext();
        }
        // 返回节点数据
        return node.getData();
    }
    // 获取长度
    public int linkSize(){
        return this.currentIndex + 1;
    }
    // 打印链表值
    public String linkToString(){
        String result = "[";
        for (int i = 0; i <= currentIndex; i++){
            result += select(i) + ",";
        }
        result = result.substring(0, result.length()-1) + "]";
        return result;
    }
}

