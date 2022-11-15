package exercise.exercise8;

import java.util.Arrays;

class Graph {
    int[][] a;
    boolean[] visited;

    int n;


    Graph() {
        a = null;
        n = 0;
    }

    void clear() {
        a = null;
        n = 0;
    }

    void setData(int[][] b) {
        n = b.length;
        a = new int[n][n];
        visited = new boolean[n];
        int i, j;

        a = Arrays.copyOf(b, b.length);
//        for (i = 0; i < n; i++)
//
//            for (j = 0; j < n; j++) a[i][j] = b[i][j];

    }

    void dispAdj() {
        int i, j;

        System.out.println("\nThe adjacency matrix:");

        for (i = 0; i < n; i++) {
            System.out.println();

            for (j = 0; j < n; j++) System.out.printf("%5d", a[i][j]);

        }

    }

    void visit(int i) {
        System.out.print(i + " ");
    }

// Hàm duyệt theo BFS bắt đầu tại đỉnh k bằng cách sử dụng MyQueue, mỗi khi lấy 1 đỉnh ra khỏi  queue thì hiển thị luôn (duyệt) đỉnh đó ra màn hình

    String breadth(int k) {
        MyQueue q = new MyQueue();
        String kq = "";
        System.out.println();
        while (true){
            System.out.print(k + " ");
            kq += k;
            visited[k] = true;
            for (int i = 0; i < a[k].length; i++) {
                if (a[k][i] == 1 && !visited[i]) {
                    q.enqueue(i);
                    visited[i] = true;
                }
            }
            if (q.isEmpty()) {
                break;
            }
            k = q.dequeue();
        }
        System.out.println();
        return kq;
    }



// Hàm kiểm tra tính liên thông của đồ thị

    boolean isConnected() {
       visited = new boolean[a.length];
       int slt = 0;
        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {
                slt++;
                breadth(i);
            }
        }
        System.out.println("số thành phần liên thông: " + slt);
        return slt == 1;
    }

// Hàm tính bậc của đỉnh k

    int degree(int k) {
        int lever = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[k][i] == 1) {
                lever++;
            }
        }
        return lever;
    }

}
