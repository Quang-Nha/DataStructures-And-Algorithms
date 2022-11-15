package exercise.exercise2;

public class SimpleSort {
    private int[] arr;
    private int n;

    public SimpleSort(int[] arr) {
        this.arr = arr;
        n = arr.length;
    }

    public void selectSort(){
        //chạy từ 0 đến phần tử gần cuối mảng
        for (int i = 0; i < n - 1; i++) {
            int min = i;//
            //chạy từ i + 1 đến cuối mảng
            for (int j = i + 1; j < n; j++) {
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
    }

    public void insertSort(){
        //lặp từ vị trí 1 đến hết mảng
        for (int i = 1; i < n; i++) {
            //gán biến trung gian là arr[i]
            int temp = arr[i];
            int j = i - 1;
            //nếu j >= 0 và giá trị mảng tại j lớn hơn temp
            //thì dịch cho giá trị tại j + 1 = tại j
            //rồi giảm j đi 1 cho lần lặp sau
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            //hết vòng while mà không thỏa mãn thì gán giá trị tại j + 1 là temp
            //tại vì cuối vòng while j-- mới thoát nên phải là vị trí j + 1
            arr[j + 1] = temp;
        }
    }

    public void display(){
        for (int i: arr) {
            System.out.print("  " + i);
        }
        System.out.println();
    }

    public int search(int value){
        for (int i: arr) {
            if (i == value) {
                return i;
            }
        }
        return -1;
    }
}
