package cauTrucDuLieuTuyenTinh.simpleLinkedList;

public class DoublyEndedListDemo {
    public static void main(String[] args) {
        DoublyEndedList<Integer> dlist =  new DoublyEndedList<>();

        dlist.insertAtTail(19);
        dlist.insertAtTail(18);
        dlist.insertAtTail(17);
        System.out.println(dlist);
    }
}
