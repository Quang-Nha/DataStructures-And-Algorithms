package cauTrucDuLieuTuyenTinh.simpleLinkedList;

import cauTrucDuLieuTuyenTinh.simpleLinkedList.Node;

public class DoublyEndedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    public void insertAtTail(T data){
        cauTrucDuLieuTuyenTinh.simpleLinkedList.Node<T> newNode = new cauTrucDuLieuTuyenTinh.simpleLinkedList.Node<T>(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        if (this.tail != null) {
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
    }

    @Override
    public String toString() {
        String print = "{";
        //cho current là head
        Node<T> current = this.head;
        //nếu current không phải là null thì cộng thêm current vào print
        //rồi cho current là node tiếp theo bằng cách cho current = biến nextNode(trỏ tới node trước đó)
        while (current != null){
            print += current;
            current = current.getNextNode();
        }
        print += "}";
        return print;
    }
}
