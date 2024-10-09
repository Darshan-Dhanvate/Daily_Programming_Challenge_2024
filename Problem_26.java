/*
Problem : Detect a Cycle in an Undirected Graph
You are given an undirected graph represented by an adjacency list. 
Your task is to determine if the graph contains any cycle. 
A cycle is formed if you can traverse through a sequence of edges that starts 
and ends at the same vertex.

Input : V = 5, E = 5
Edges = [[0, 1], [1, 2], [2, 3], [3, 4], [4, 0]]

Output : true
*/

package problems;
import java.util.*;

public class Problem_26 {
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

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(0);
        adj.get(0).add(4);

        System.out.println(isCycle(V, adj));
    }

    // Function to check if the graph contains a cycle
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        
        // Run DFS from each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle found
    }

    // DFS to detect cycle
    private static boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                // If neighbor is not visited, recurse on it
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If neighbor is visited and is not the parent of the current node, a cycle is detected
                return true;
            }
        }

        return false;
    }
}
