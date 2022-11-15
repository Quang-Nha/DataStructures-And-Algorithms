package exercise.exercise8;

public class Main {

// Hàm nhập ma trận a từ bàn phím

    static void input(int[][] b, int n) {

    }

    public static void main(String[] args) {
        Graph g = new Graph();

        int n = 6;

        int[][] b = {
            {0,1,1,0,1},
            {1,0,1,0,0},
            {1,1,0,1,0},
            {0,0,1,0,0},
            {1,0,0,0,0},
        };

        input(b, n);

        g.setData(b);

        g.dispAdj();

        g.breadth(1);

        System.out.println("Is G is connected? " + g.isConnected());

        System.out.println("Degree of the vertex A in G is " + g.degree(0));

        System.out.println();

    }

}
