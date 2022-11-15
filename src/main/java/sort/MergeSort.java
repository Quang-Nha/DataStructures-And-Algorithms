package sort;

import java.util.Arrays;

public class MergeSort {
    void merge(int[] arr, int l, int m, int h){
        //cho n1 = chiều dài nửa bên trái mảng
        //n2 = chiều dài nửa bên phải
        int n1 = m - l + 1;
        int n2 = h - m;
        //tạo 2 mảng mới với độ dài là n1 và n2
        int[] left = new int[n1];
        int[] right = new int[n2];

        //gán giá trị mảng từ vị trí l đến h cho 2 mảng vừa tạo
        //mảng 1 gán nửa trái, mảng 2 gán nửa phải
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;
        //đến khi i hoặc j chạy hết mảng của nó thì dừng lặp
        //so sánh mảng 1 tại i và mảng 2 tại j nếu cái nào nhỏ hơn thì gán lại cho mảng gốc
        //tại vị trí k rồi tăng k lên 1 và i hoặc j nếu được dùng để gán rồi cũng tăng 1
        while (i < n1 && j < n2){
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            }else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        //nếu mảng nào chưa duyệt hết tức i hoặc j chưa chạy đến cuối mảng
        //thì gán nốt phần còn lại của nó vào mảng gốc
        while (i < n1){
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    void sort(int[] arr, int l, int h){
        //nếu chỉ số l < h thì mảng có từ 2 giá trị trở lên, nếu ko nghĩa là còn 1 giá trị thì dừng
        if (l < h) {
            //tính giá trị ở giữa
            int m = l + (h - l) / 2;
            sort(arr, l, m);//gọi lại hàm với mảng và chỉ số nửa trái
            sort(arr, m + 1, h);//gọi lại hàm với mảng và chỉ số nửa phải
            //đến khi đệ quy còn 1 phần tử thì gọi hàm sắp sếp 2 nửa trên và
            //đệ quy quy hồi đến khi sắp xếp 2 nửa mảng ban đầu
            merge(arr, l, m, h);
        }
    }

    void print(int[] arr){
        for (int n: arr) {
            System.out.print(n + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int arr[] = {100, 20, 30, 10, 80, 70, 50};
        System.out.println("before sort: ");
        mergeSort.print(arr);
        mergeSort.sort(arr, 0, arr.length- 1);
        System.out.println("after sort: ");
        mergeSort.print(arr);
    }
}
