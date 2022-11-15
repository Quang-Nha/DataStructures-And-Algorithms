package exercise.exercise4;

// Xây dựng danh sách móc nối
class MyList {
    Node head, tail;

    MyList() {
        head = tail = null;
    }

    void clear() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    // Hàm thêm 1 người vào đuôi danh sách móc nối
    void add(Person x) {
        Node add = new Node(new Person(x.name, x.age));
        if (isEmpty()) {
            head = add;
            tail = add;
        }else {
            tail.next = add;
            tail = add;
        }

    }

    // Hàm thêm nhiều người vào danh sách móc nối, thông tin ( tên và tuổi) của mọi người được lưu trong 2 mảng a và b
    void addMany(String[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            add(new Person(a[i], b[i]));
        }
    }

    // Hàm duyệt danh sách móc nối
    void traverse() {
        Node tmp = head;
        while (tmp != null){
            System.out.println(tmp.info);
            tmp = tmp.next;
        }
    }

    public void swap(Node a, Node b){
        Person tmp = a.info;
        a.info = b.info;
        b.info = tmp;
    }

    // Hàm sắp xếp theo tên bằng selection sort
    void sortByName() {
        Node i = head;
        Node j;
        while (i.next != null){
            j = i.next;
            Node min = i;
            while (j != null){
                if (j.info.name.compareTo(min.info.name) < 0) {
                    min = j;
                }
                j = j.next;
            }
            if (min != i) {
                swap(min, i);
            }
            i = i.next;
        }
    }

}
