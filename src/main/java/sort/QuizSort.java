package sort;

import java.util.Arrays;

public class QuizSort {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //sắp xếp mảng theo thứ tự thành nửa trái <= pivot + pivot + phải > pivot và trả về chỉ số pivot
    private int partition(int[] a, int start, int end){
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

    public void quickSort(int[] a, int start, int end){
        if (start < end) {
            int pivot = partition(a, start, end);//gọi hàm chia theo pivot và gán pivot theo nó
            quickSort(a, start, pivot - 1);//gọi đệ quy 2 nửa và tiếp tục chia
            quickSort(a, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        QuizSort sort = new QuizSort();
        int[] b = {10, 5, 8, 20, 15};
        System.out.println("before sort: ");
        System.out.println(Arrays.toString(b));
        sort.quickSort(b, 0, b.length - 1);
        System.out.println("after sort: ");
        System.out.println(Arrays.toString(b));
    }
}
