package test;

import java.util.Arrays;
import java.util.Locale;

public class FomatText {
    public static void main(String[] args) {
        String text = " ab    2   4    5       6";
        text = text.trim();//nước bắt buộc nếu không khi cắt chuỗi thành mảng bằng " " sẽ tạo ra phần tử đầu tiên là ""
        text = text.replaceAll("\\s+", " ");
        String[] cut = text.split(" ");

        text =text.substring(0, 1).toUpperCase(Locale.ROOT) + text.substring(1);//cho chữ đầu tiên sang chữ hoa
//        noi = String.valueOf(noi.charAt(0)).toUpperCase(Locale.ROOT) + noi.substring(1); cách 2
//        noi = (noi.charAt(0) + "").toUpperCase(Locale.ROOT) + noi.substring(1); cách 3
        System.out.println(text);
    }
}
