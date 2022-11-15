package exercise.exercise6;

public class Test {
    static int[] a = new int[100];
    static int n = 3;

    static void print(int[] a, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    static void quayLui(int i) {
        for (int j = 0; j <= 1; j++) {
            a[i] = j;
            if (i == n) {
                print(a, n);
            } else {
                quayLui(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        quayLui(1);
    }
}
