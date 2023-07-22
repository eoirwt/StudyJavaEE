package supperLink;

/**
 * ClassName: Node
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author guohong
 * @Create 2023/3/8 8:53
 * @Version 1.0
 */
public class Node {
    private Integer data;
    private Node next;
    public Node(){

    }
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    public void setData(Integer data){
        this.data = data;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Integer getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
}
