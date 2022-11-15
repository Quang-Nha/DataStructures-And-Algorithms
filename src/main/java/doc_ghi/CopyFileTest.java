package doc_ghi;

import java.io.*;

public class CopyFileTest {
    public static void main(String args[]){
        try (
                DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("input.txt")))
        ) {
            String c = in.readUTF();
            System.out.println(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
