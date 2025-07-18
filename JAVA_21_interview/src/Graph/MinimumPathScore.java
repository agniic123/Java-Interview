package Graph;

import java.util.*;

public class MinimumPathScore {
    public int minScore(int n, int[][] roads) {
        // Build the graph using adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], score = road[2];
            graph.get(u).add(new int[]{v, score});
            graph.get(v).add(new int[]{u, score});
        }

        // BFS traversal from city 1
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        int minScore = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int[] neighbor : graph.get(current)) {
                int nextCity = neighbor[0];
                int edgeScore = neighbor[1];

                minScore = Math.min(minScore, edgeScore); // Update minimum score

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }

        return minScore;
    }

    // Example usage
    public static void main(String[] args) {
        MinimumPathScore solver = new MinimumPathScore();
        int[][] roads = {
                {1, 2, 9},
                {2, 3, 6},
                {1, 4, 5},
                {4, 3, 7}
        };
        int n = 4;
        System.out.println("Minimum score: " + solver.minScore(n, roads)); // Output: 5
    }
}
