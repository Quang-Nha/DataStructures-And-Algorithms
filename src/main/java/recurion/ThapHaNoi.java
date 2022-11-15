package recurion;

import java.util.Scanner;

public class ThapHaNoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            haNoiTower(20, 'A', 'B', 'C');
            String next = scanner.nextLine();
            if (next.equals("y")) {
                break;
            }
        }
    }

    public static void haNoiTower(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("chuyển 1 từ " + a + " sang " + c);
        }else {
            haNoiTower(n - 1, a, c, b);
            System.out.println("chuyển " + n + " từ " + a + " sang " + c);
            haNoiTower(n - 1, b, a, c);
        }
    }
}
