package cauTrucDuLieuTuyenTinh.doublyLinkedList;

public class Node {
    private Node pre;
    private Node next;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if (next == null) {
            return this.data + "";
        }
        return this.data + ", ";
    }
}
