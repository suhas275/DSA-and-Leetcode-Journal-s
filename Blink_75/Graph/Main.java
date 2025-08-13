package Blink_75.Graph;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // If already cloned, return the clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone with the same value
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Recursively clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example: adjList = [[2,4],[1,3],[2,4],[1,3]]
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(2, 4)); // Node 1 neighbors
        adjList.add(Arrays.asList(1, 3)); // Node 2 neighbors
        adjList.add(Arrays.asList(2, 4)); // Node 3 neighbors
        adjList.add(Arrays.asList(1, 3)); // Node 4 neighbors

        Node startNode = buildGraph(adjList);
        Solution solution = new Solution();
        Node clonedGraph = solution.cloneGraph(startNode);

        // Print cloned graph to verify
        printGraph(clonedGraph);
    }

    // Helper: Build graph from adjacency list
    private static Node buildGraph(List<List<Integer>> adjList) {
        if (adjList.isEmpty()) return null;

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= adjList.size(); i++) {
            map.put(i, new Node(i));
        }

        for (int i = 0; i < adjList.size(); i++) {
            Node node = map.get(i + 1);
            for (int neighborVal : adjList.get(i)) {
                node.neighbors.add(map.get(neighborVal));
            }
        }

        return map.get(1); // Return the first node as starting point
    }

    // Helper: BFS print to verify structure
    private static void printGraph(Node node) {
        if (node == null) {
            System.out.println("[]");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print("Node " + curr.val + " neighbors: ");
            for (Node neighbor : curr.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
            System.out.println();
        }
    }
}
