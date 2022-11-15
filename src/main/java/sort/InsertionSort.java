package sort;

public class InsertionSort {
    public void insertionSort(int arr[]){
        //lặp từ vị trí 1 đến hết mảng
        for (int i = 1; i < arr.length; i++) {
            //gán biến trung gian là giá trị tại vị trí đang lặp arr[i]
            int temp = arr[i];

            int j = i - 1;
            //nếu j >= 0 và giá trị mảng tại j lớn hơn temp
            //thì gán cho giá trị tại j + 1 = tại j
            //rồi giảm j đi 1 cho lần lặp sau
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            // đến vị trí j nào đó không thỏa mãn thì vòng while kết thúc
            // gán giá trị tại j + 1 là temp
            // tại vì cuối vòng while j-- mới rồi so sánh không đủ điều kiện và thoát lặp while
            // nên phải là vị trí j + 1 cần gán giá trị temp
            arr[j + 1] = temp;
            for (int k : arr) {
                System.out.print(k + " ");
            }
            System.out.println("");
        }
    }
}
