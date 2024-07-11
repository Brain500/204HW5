package greedy;

import java.util.*;

public class TSP {

    public int tsp(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        visited[start] = true;
        return tspUtil(graph, visited, start, n, 1, 0, Integer.MAX_VALUE);
    }

    private int tspUtil(int[][] graph, boolean[] visited, int currPos, int n, int count, int cost, int ans) {
        if (count == n && graph[currPos][0] > 0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[currPos][i] > 0) {
                visited[i] = true;
                ans = tspUtil(graph, visited, i, n, count + 1, cost + graph[currPos][i], ans);
                visited[i] = false;
            }
        }
        return ans;
    }
}
