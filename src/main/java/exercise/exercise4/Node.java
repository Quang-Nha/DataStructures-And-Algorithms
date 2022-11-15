package exercise.exercise4;

// Lớp Node chứa thông tin của mỗi người và biến next để trỏ tới nút tiếp theo
class Node {
    Person info;
    Node next;

    Node(Person x, Node p) {
        info = x;
        next = p;
    }

    Node(Person x) {
        this(x, null);
    }
}
