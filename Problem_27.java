/*
Problem : Find the Shortest Path in an Unweighted Graph
You are given an unweighted graph represented by an adjacency list. 
Your task is to find the shortest path (in terms of the number of edges) 
between two given nodes in the graph.

Input : V = 5
Edges = [[0, 1], [0, 2], [1, 3], [2, 3], [3, 4]]
start = 0
end = 4

Output : 
*/

package problems;
import java.util.*;

public class Problem_27 {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initializing adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        int start = 0;
        int end = 4;
        List<Integer> path = findShortestPath(V, adj, start, end);

        if (path != null) {
            System.out.println("Shortest path: " + path);
        } else {
            System.out.println("No path found.");
        }
    }

    // Function to find the shortest path using BFS
    public static List<Integer> findShortestPath(int V, ArrayList<ArrayList<Integer>> adj, int start, int end) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];  // To track the parent of each node to reconstruct the path
        Arrays.fill(parent, -1);    // Initialize parent array with -1

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        // BFS traversal
        while (!queue.isEmpty()) {
            int node = queue.poll();

            // If we reach the end node, construct the path
            if (node == end) {
                return constructPath(parent, start, end);
            }

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = node;  // Track the parent of each visited node
                }
            }
        }

        return null;  // Return null if no path is found
    }

    // Function to reconstruct the path from the parent array
    private static List<Integer> constructPath(int[] parent, int start, int end) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);  // Reverse the path as we constructed it backwards
        return path;
    }
}
