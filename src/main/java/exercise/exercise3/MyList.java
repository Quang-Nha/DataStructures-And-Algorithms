package exercise.exercise3;

public class MyList {
    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // Hàm thêm  một phần tử vào đầu danh sách
    void addHead(int x) {
        Node n = new Node(x);
        n.next = head;
        head = n;
    }


    // Hàm thêm nhiều phần tử vào đầu danh sách
    void addMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            addHead(a[i]);
        }
    }

    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    // Hàm Duyệt danh sách
    void traverse() {
        Node tmp = head;
        while (tmp != null) {
            visit(tmp);
            tmp = tmp.next;
        }
    }

    // Hàm tìm kiếm phần tử cóa giá trị lớn hơn x, nếu tìm thấy thì hiển thị chỉ số của phần tử ra màn hình, giả sử phần tử đầu tiên có chỉ số là 0;
    void Search(int x) {
        int index = 0;
        Node tmp = head;
        System.out.print("Found index(" + x + "): ");
        while (tmp != null){
            if (tmp.info > x) {
                System.out.print(index);
                return;
            }
            index ++;
            tmp = tmp.next;
        }
        System.out.println("Not found");
    }
}
