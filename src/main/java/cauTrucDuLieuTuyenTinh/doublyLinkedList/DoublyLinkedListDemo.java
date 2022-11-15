package cauTrucDuLieuTuyenTinh.doublyLinkedList;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList intergers = new DoublyLinkedList();

        intergers.insertAtHead(5);
        intergers.insertAtHead(10);
        intergers.insertAtHead(2);
        intergers.insertAtHead(12);
        intergers.insertAtHead(19);
        intergers.insertAtHead(20);

        System.out.println(intergers);
    }
}
