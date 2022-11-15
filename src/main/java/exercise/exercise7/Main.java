package exercise.exercise7;

import java.util.Scanner;

public class Main {

// Nhập các phần tử trong mảng a;

    static void input(int[] a, int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
    }

    public static void main(String[] args) {
        BTree t = new BTree();

        int n = 7;

        int[] a = new int[n];

        input(a, n);
        t.insertMany(a);
        System.out.println("\nPre-order traverse:");
        t.preOrder(t.root);
        System.out.println("\nIn-order traverse:");
        t.inOrder(t.root);

        System.out.println("\nSearch:");

        t.search(t.root, 10);

        System.out.println();
    }
}
