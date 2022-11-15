package cauTrucDuLieuTuyenTinh.doublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public void insertAtHead(int data){
        Node newNode = new Node(data);
        if (this.tail == null) {
            this.tail = newNode;
        }
        newNode.setNext(this.head);
        if (this.head != null) {
            this.head.setPre(newNode);
        }
        this.head = newNode;
    }

    public int length(){
        int length = 0;
        Node current = this.head;
        while (current != null){
            length++;
            current = current.getNext();
        }
        return length;
    }

    @Override
    public String toString() {
        String result = "{";
        Node current = this.head;
        while (current != null){
            result += current;
            current = current.getNext();
        }
        return result + "}";
    }
}
