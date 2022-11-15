package exercise.exercise5;

import java.util.EmptyStackException;

public class Node {
    int info;
    Node next;

    Node(int x, Node p) {
        info = x;
        next = p;
    }
}

// Xây dựng Stack

class MyStack {
    Node head;

    MyStack() {
        head = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    // Hàm đẩy 1 phần tử vào stack
    void push(int x) {
        head = new Node(x, head);
    }

    // Hàm lấy 1 phần tử ra khỏi stack
    int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int x = head.info;
        head = head.next;
        return x;
    }

    // Hàm thuật toán chuyển đổi 1 số nguyên ở hệ đếm thập phân sang nhị phân
    // ( Ta chia liên tiếp số nguyên đó cho 2 đến bao giờ //thương bằng 0 thì dừng lại, kết quả của phép chuyển đổi là phần dư của các phép chia theo thứ tự ngược lại)
    public String covertToBinary(int x) {

        //taọ vòng lặp lấy push vào stack số dư của x / 2 và giảm x đi 2
        while (x != 0) {
            push(x % 2);
            x /= 2;
        }

        //pop stack đến hết cộng kết quả vào biến String
        String binary = "";
        while (!isEmpty()) {
            binary += pop();
        }
        return binary;
    }
}

class Main {
    public static void main(String[] args) {
        int x = 10;
        MyStack t = new MyStack();
        String result = t.covertToBinary(x);
        System.out.println(result);
    }
}



