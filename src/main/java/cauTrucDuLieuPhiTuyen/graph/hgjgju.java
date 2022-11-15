package cauTrucDuLieuPhiTuyen.graph;

import java.util.Stack;

public class hgjgju {
    boolean isVisited(int visitedIndex[], int index) {
        for (int i = 0; i < visitedIndex.length; i++) {
            if (visitedIndex[i] == index) {
                return true;
            }
        }

        return false;
    }

    boolean check(int numVertices, int[][] edges, int startingVertice, int endingVertice) {
        if (startingVertice == endingVertice) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(startingVertice);

        int[] visitedIndex = new int[edges.length];
        int index = 0;

        while (!stack.isEmpty()) {
            int currNode = stack.peek();
            boolean hasPathOut = false;
            for (int i = 0; i < edges.length; i++) {
                if (!(isVisited(visitedIndex, i))) {
                    if (edges[i][1] == endingVertice) {
                        return true;
                    }

                    stack.push(edges[i][1]);
                    visitedIndex[index++] = i;
                    hasPathOut = true;
                    break;
                }
            }

            if (!hasPathOut) {
                stack.pop();
            }
        }
        return false;
    }
}
