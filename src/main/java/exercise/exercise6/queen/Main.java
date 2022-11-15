package exercise.exercise6.queen;

import java.util.Scanner;

//=============================
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        // n là số quân hậu và bàn cờ nxn
        int n = sc.nextInt();
        // tạo mảng n + 1 phần tử vì không muốn tính từ vị trí hàng 0, cột 0 mà từ hàng 1, cột 1
        Queen t = new Queen(n, new int[n + 1]);
        // gọi hàm kiểm tra vị trí quân hậu bắt đầu từ hàng 1
        t.test(1);
        System.out.println();
    }
}
