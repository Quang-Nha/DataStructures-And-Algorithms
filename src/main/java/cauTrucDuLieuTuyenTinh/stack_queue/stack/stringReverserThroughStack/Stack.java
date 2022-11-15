package cauTrucDuLieuTuyenTinh.stack_queue.stack.stringReverserThroughStack;

// Lớp tạo ra cấu trúc Stack
class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    // Thêm phần tử vào Satck
    public void push(char j) {
        stackArray[++top] = j;
    }

    //Lấy một phần tử ra khỏi Stack
    public char pop() {
        return stackArray[top--];
    }

    // Return lại phần tử trên cùng của Stack
    public char peek() {
        return stackArray[top];
    }

    // kiểm tra tính rỗng của Stack
    public boolean isEmpty() {
        return (top == -1);
    }
}
