package cauTrucDuLieuPhiTuyen.graph.dijkstra;

// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath {
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V = 9;

    //tìm đỉnh có đường đi đến nguồn nhỏ nhất trong tổng các đỉnh chưa đánh dấu
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            //nếu giá trị tại v chưa được xét tức là sptSet[v] == false và đường đi của nó là dist[v] nhỏ hơn min thì
            //gán cho min là giá trị tại dist[v] và chỉ số min là v
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        //trả về chỉ số min tìm được
        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src)
    {
        //tạo mảng chứa khoản cách các đỉnh đến điểm đầu
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        //mảng lưu các giá trị đỉnh của đường đi trước đó của đỉnh vị trí i
        int pre[] = new int[V];

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        //mảng đánh dấu chỉ số của đỉnh đã được duyệt chưa
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        //gán tất cả các giá trị 2 mảng là số max và false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        //gán giá trị tại điểm đầu là 0
        dist[src] = 0;
        pre[src] = src;//cho đỉnh trong bước đi trước của đỉnh bắt đầu là chính nó vì
        // trong vòng for sẽ ko cập nhật do dist[src] = 0 nó sẽ được chọn là u = dist min và đánh dấu đã chọn

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            //gán số int u là chỉ số có giá trị nhỏ nhất của mảng dist
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            //đánh dấu chỉ số này đã duyệt rồi trong mảng sptSet
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            //chạy qua tất cả các đỉnh liên thông với u và so sánh
            for (int v = 0; v < V; v++) {

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                //những đỉnh chưa duyệt là false !sptSet[v], có liên thông với u(đỉnh đang xét) graph[u][v] != 0
                // //giá trị tại u có thể vô cực vì nếu từ đầu src ko giáp đỉnh nào hàm tìm min sẽ tìm ra min là vô cực
                // và giá trị u(dường đi điển đầu đến u) + độ dài uv < giá trị tại v thì
                //giá trị tại v gán lại bằng giá trị tại u + khoảng cách uv
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pre[v] = u;//cập nhật bước đi trước của v
                }
            }

        }

        //in ra đỉnh trong đường đi trước của đỉnh vị trí i
        for (int i = 0; i < pre.length; i++) {
            System.out.println(i + " " + pre[i]);
        }
        // print the constructed distance array
        //in ra mảng dist là khoảng cách các đỉnh đến điểm đầu
        printSolution(dist);
    }

    // Driver method
    public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}
// This code is contributed by Aakash Hasija

