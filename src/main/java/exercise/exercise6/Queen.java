package exercise.exercise6;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queen {
    static int q[] = new int[9];
    static int n = 8;
    static boolean dk;

    static void print(int[] a) {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    static void queen(int r) {
        if (r == n + 1) {
            print(q);
        }else {
            for (int j = 1; j <= n; j++) {
                dk = true;
                for (int i = 1; i <= r - 1; i++) {
                    if (q[i] == j || q[i] == j + r - i || q[i] == j - r + i) {
                        dk = false;
                    }
                }
                if (dk) {
                    q[r] = j;
                    queen(r + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        queen(1);
    }
}
