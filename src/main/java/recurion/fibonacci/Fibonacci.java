package recurion.fibonacci;

public class Fibonacci {
    public static int getFibonacci(int n) {
        if (n < 3) {
            return 1;
        }

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(getFibonacci(8));
    }
}
