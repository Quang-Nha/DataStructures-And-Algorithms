package sort;

public class SelectionSort {
    public void selectionSort(int arr[]) {
        //chạy từ 0 đến phần tử gần cuối mảng
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;//
            //chạy từ i + 1 đến cuối mảng
            for (int j = i + 1; j < arr.length; j++) {
                //nếu giá trị mảng tại chỉ số j < tại min thì gán min = j
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //nếu min khác i tức là giá trị nhỏ nhất không nằm ở chỉ số i
            if (min != i) {
                //đổi chỗ giá trị tại min và i cho nhau
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
            //chạy đến phần tử i tiếp theo
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
