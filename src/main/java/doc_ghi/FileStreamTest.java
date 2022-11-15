package doc_ghi;

import java.io.*;
import java.util.Scanner;

public class FileStreamTest {

    public static void main(String args[]) {

        try {
            double bWrite[] = {2.0, 3.0};
            OutputStream os = new FileOutputStream("test.txt");
            BufferedOutputStream bin = new BufferedOutputStream(os);
            for (int x = 0; x < bWrite.length; x++) {
//                os.write(bWrite[x]);   // writes the bytes
                bin.write((bWrite[x] + " ").getBytes());   // writes the bytes
            }

            bin.close();
            os.close();
            InputStream is = new FileInputStream("C:\\Users\\LE_NHA\\Desktop\\câu hỏi java.docx");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read());
            }
            is.close();

            File file = new File("test.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                System.out.print(sc.next() + " ");
            }

        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
}