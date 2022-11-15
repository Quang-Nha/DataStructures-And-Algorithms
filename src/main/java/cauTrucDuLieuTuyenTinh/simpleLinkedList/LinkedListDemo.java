package cauTrucDuLieuTuyenTinh.simpleLinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertAtTail(50);
        list.insertAtTail(50);
        list.insertAtTail(80);
        list.insertAtTail(100);
        list.insertAtTail(100);
        list.insertAtTail(150);

        list.insertAtHead(5);
        list.insertAtHead(5);
        list.insertAtHead(10);
        list.insertAtHead(15);
        list.insertAtHead(20);
        list.insertAtHead(25);
        list.insertAtHead(30);
        list.insertAtHead(35);
        list.insertAtHead(40);
        list.insertAtHead(40);

        list.deleteFromHead();
        list.deleteFromTail();
        list.deleteNode(100);
        list.insertAfter(50, 70);
        list.insertBefore(100, 80);
        list.insertAtTail(150);
        list.selectionSort();

        System.out.println(list);
        System.out.println("Length: " + list.length());
        System.out.println("Found: " + list.search(50));
    }
}
