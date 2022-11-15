package exercise.exercise9;

// Lớp EffSort

import sort.QuizSort;

import java.util.Scanner;

class EffSort {
    int[] a;
    int n;

    EffSort() {
    }

    EffSort(int[] b) {
        int i;
        n = b.length;
        a = new int[n];
        for (i = 0; i < n; i++) a[i] = b[i];
    }

    void display() {
        int i;
        for (i = 0; i < n; i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }

    //--------------------------------------------------
    void swap(int[] a, int i, int k) // Hàm hoán vị
    {
        int x;
        x = a[i];
        a[i] = a[k];
        a[k] = x;
    }
//==================================================
  /*CAI DAT GIAI THUAT QUICKSORT}
    Phương thức partition sẽ phân hoạch danh sách từ low đến up thành 2 phần:
    các nút có nội dung <= a[pivot] nằm bên trái pivot, các nútt có nội dung > a[pivot] nằm bên phải
    Chọn nút trục=a[low], quét 2 đầu, i từ dưới lên, j trên xuống và đổi chỗ các phần tử sai chỗ, khi kết thúc quét thì đổi chỗ cho a[low]
    và a[j], vậy nút trục sẽ chuyển đến vị trí j;*/


    //sắp xếp mảng theo thứ tự thành nửa trái <= pivot + pivot + phải > pivot và trả về chỉ số pivot
    private int partition(int start, int end){
        int pivot = a[end];//cho pivot là giá trị mảng tại end
        int i = start;//i là chỉ số đầu
        for (int j = start; j <= end - 1; j++) {//lặp mảng từ đầu đến sát cuối
            if (a[j] <= pivot) {//nếu a[j] <= pivot thì đổi chỗ giá trị tại i và j rồi tăng i lên 1
                swap(a, i, j);
                i++;
            }
        }//cuối cùng chỉ số sau i sẽ nhỏ hơn tại pivot(tại end)

        //đổi chỗ giá trị tại end và i, khi này i chính là
        //pivot với nửa trước nhỏ hơn, nửa sau lớn hơn
        swap(a, i ,end);

        return i;//trả về chỉ số i
    }

    public void quickSort(int start, int end){
        if (start < end) {
            int pivot = partition(start, end);//gọi hàm chia theo pivot và gán pivot theo nó
            quickSort(start, pivot - 1);//gọi đệ quy 2 nửa và tiếp tục chia
            quickSort(pivot + 1, end);
        }
    }

    //-----------------------------------------------------
    void quickSort() {
        quickSort(0, n - 1);
    }

    //==================================================
    public static class Main {

        static int[] b;

        // Phương thức input để nhập giá trị cho mảng b;
        static void input() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập số phần tử: ");
            int num = 0;
            while (true) {
                try {
                    num = Integer.parseInt(scanner.nextLine());

                    if (num > 0) {
                        break;
                    }

                    System.out.print("số phần tử phải lớn hơn 0: ");
                } catch (NumberFormatException e) {
                    System.out.print("hãy nhập vào số nguyên: ");
                }
            }

            b = new int[num];

            for (int i = 0; i < b.length; i++) {
                while (true) {
                    System.out.print("Nhập giá trị phần tử thứ " + (i + 1) + ": ");
                    try {
                        b[i] = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("hãy nhập vào số nguyên");
                    }
                }
            }

        }

        /*Trong phương thức main phải xây dựng menu để gọi tới các phương thức cần thiết như input(b), gọi tới phương thức khởi tạo  EffSort(b) và  quickSort(); display() trong lớp EffSort*/
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            EffSort effSort = null;

            while (true) {
                System.out.println();
                System.out.println("+-------------------Menu------------------+");
                System.out.println("1. Nhập dữ liệu.");
                System.out.println("2. Sắp xếp.");
                System.out.println("3. Hiển thị giá trị mảng.");
                System.out.println("0. thoát chương trình.");
                System.out.print("Lựa chọn của bạn: ");

                int choice;
                while (true) {
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice >= 0 && choice <= 3) {
                            break;
                        }
                        System.out.print("Nhập lại theo danh sách trên: ");

                    } catch (NumberFormatException e) {
                        System.out.print("Hãy nhập vào số nguyên: ");
                    }
                }

                switch (choice) {
                    case 1:
                        input();
                        effSort = new EffSort(b);
                        break;
                    case 2:
                        if (effSort == null) {
                            System.out.println("chưa nhập dữ liệu, không thể xắp xếp");
                        } else {
                            effSort.quickSort();
                        }
                        break;
                    case 3:
                        if (effSort == null) {
                            System.out.println("chưa nhập dữ liệu, không thể hiển thị");
                        } else {
                            effSort.display();
                        }
                        break;
                    case 0:
                        System.out.println("Tạm biệt, hẹn gặp lại!");
                        return;
                }
            }

        }
    }
}

