package doc_ghi;

import java.io.*;
import java.util.Scanner;

public class CopyFile2 {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("C:\\Users\\LE_NHA\\Desktop\\nhap du lieu tu java.docx");
            out = new FileWriter("C:\\Users\\LE_NHA\\Desktop\\nhap du lieu tu java.docx", true);

            String c = "start";
            while (true) {
                c = scanner.nextLine() + "\n";
                if (c.equalsIgnoreCase("q\n") || c.equalsIgnoreCase("quit\n")) {
                    break;
                }
                out.write(c);
            }

        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
