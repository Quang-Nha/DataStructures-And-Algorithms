package exercise.exercise1;

public class SimpleSort {
    private int[] arr;
    private int n;

    public SimpleSort(int[] arr) {
        this.arr = arr;
        n = arr.length;
    }

    public void display() {
        for (int i : arr) {
            System.out.print("  " + i);
        }
        System.out.println();
    }

    void swap(int i, int k) // Hàm hoán vị
    {
        int x;
        x = arr[i];
        arr[i] = arr[k];
        arr[k] = x;
    }

    public void bubbleSort(){
        int length = n;
        while(length > 1){//chạy vòng lặp ngoài đến khi length = 2
            //tức là vòng for chỉ chạy đến 1 vì i < length
            int temp;
            for (int i = 1; i < length; i++) {//lặp từ 1 đến length
                //nếu giá trị mảng tại chỉ số i nhỏ hơn tại i - 1 thì đổi chỗ cho nhau
                if (arr[i] < arr[i - 1]) {
                    swap(i, i -1);
                }
            }
            display();
            System.out.println();
            //trừ length đi 1 để các vòng for sau giảm đi mỗi lần giảm 1
            length--;
        }
    }
}
