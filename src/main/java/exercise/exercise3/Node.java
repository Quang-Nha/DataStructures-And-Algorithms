package exercise.exercise3;

public class Node {
    int info;
    Node next;

    Node(int x, Node p) {
        info = x;
        next = p;
    }

    Node(int x) {
        this(x, null);
    }
}


