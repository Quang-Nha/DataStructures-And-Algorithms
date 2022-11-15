package exercise.exercise8;

// xây dựng lớp queue cso tên là MyQueue để phục vụ cho duyệt đồ thị theo BFS

import java.util.LinkedList;

class MyQueue {
    LinkedList<Integer> t;

    MyQueue() {
        t = new LinkedList<>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(int x) {
        t.add(x);
    }

    int dequeue() {
        return (t.removeFirst());
    }

}



