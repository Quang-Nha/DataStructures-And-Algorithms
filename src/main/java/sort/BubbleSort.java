package sort;

public class BubbleSort {
    public void bubbleSort(int arr[]){

        int length = arr.length;
        while(length > 1){//chạy vòng lặp ngoài đến khi length = 2
            //tức là vòng for chỉ chạy đến 1 vì i < length

            // đầu vòng lặp đánh dấu chưa đổi chỗ
            boolean swapped  = false;
            int temp;
            for (int i = 1; i < length; i++) {//lặp từ 1 đến length
                //nếu giá trị mảng tại chỉ số i nhỏ hơn tại i - 1 thì đổi chỗ cho nhau
                if (arr[i] < arr[i - 1]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    // đánh dấu đã đổi chõ
                    swapped  = true;
                }
            }

            // nếu vòng lặp trong không cần đổi chỗ lần nào nữa tức mảng đã xắp xếp xong,
            // không cần so sánh thêm thoát luôn vòng lặp ngoài
            if (!swapped ) {
                break;
            }
            //trừ length đi 1 để các vòng for sau giảm đi mỗi lần giảm 1
            length--;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
