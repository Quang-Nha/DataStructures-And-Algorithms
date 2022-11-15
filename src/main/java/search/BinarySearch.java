package search;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LE_NHA
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(find(2));
    }

    public static int find(int data) {
        int[] arr = {1, 2, 5, 9, 10, 20};
        int min = 0;
        int max = arr.length - 1;
        int mid;
        int index = -1;
        while (min <= max) {
            mid = min + (max - min) / 2;
            
            if (arr[mid] == data) {
                index = arr[mid];
                break;
            //nếu giá trị mảng tại mid nhỏ hơn data
            //thì min = mid + 1 để lấy nữa phía sau của mảng
            }else if (arr[mid] < data) {
                min = mid + 1;
            //ngược lại thì max = mid - 1
            }else {
                max = mid - 1;
            }
        }
        return index;
    }
}
