package cauTrucDuLieuTuyenTinh.stack_queue.stack.stringReverserThroughStack;

import java.io.IOException;

public class StringReverserThroughStack {
    private String input;
    private String output;

    // Hàm khởi tạo
    public StringReverserThroughStack(String in) {
        input = in;
    }

    // Hàm đảo xâu sử dụng Stack
    public String doRev() {
        int stackSize = input.length();
        Stack theStack = new Stack(stackSize);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            theStack.push(ch);
        }
        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }

    // Hàm main
    public static void main(String[] args)
            throws IOException {
        String input = "Java Source and Support";
        String output;
        StringReverserThroughStack theReverser =
                new StringReverserThroughStack(input);
        output = theReverser.doRev();
        System.out.println("Reversed: " + output);
    }

}
