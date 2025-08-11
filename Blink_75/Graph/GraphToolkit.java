package Blink_75.Graph;

import java.util.*;

public class GraphToolkit {

    // =============================
    // Graph Representation
    // =============================
    static List<List<Integer>> buildAdjList(int n, int[][] edges, boolean directed) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            if (!directed) graph.get(v).add(u);
        }
        return graph;
    }

    static List<List<Edge>> buildWeightedAdjList(int n, int[][] edges, boolean directed) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Edge(v, w));
            if (!directed) graph.get(v).add(new Edge(u, w));
        }
        return graph;
    }

    static class Edge {
        int to, weight;
        Edge(int t, int w) { to = t; weight = w; }
    }

    // =============================
    // BFS (Unweighted shortest path / traversal)
    // =============================
    static void bfs(List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        System.out.println();
    }

    // =============================
    // DFS (Recursive)
    // =============================
    static void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int nei : graph.get(node)) {
            if (!visited[nei]) dfs(graph, nei, visited);
        }
    }

    // =============================
    // Topological Sort (Kahn's Algorithm)
    // =============================
    static List<Integer> topoSort(List<List<Integer>> graph) {
        int n = graph.size();
        int[] indeg = new int[n];
        for (int u = 0; u < n; u++)
            for (int v : graph.get(u)) indeg[v]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.add(i);

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);
            for (int v : graph.get(u)) {
                if (--indeg[v] == 0) q.add(v);
            }
        }
        return topo;
    }

    // =============================
    // Dijkstra's Algorithm (Shortest Path)
    // =============================
    static long[] dijkstra(List<List<Edge>> graph, int src) {
        int n = graph.size();
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0, src});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d > dist[u]) continue;
            for (Edge e : graph.get(u)) {
                int v = e.to; long w = e.weight;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new long[]{dist[v], v});
                }
            }
        }
        return dist;
    }

    // =============================
    // Union-Find (Disjoint Set Union)
    // =============================
    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    // =============================
    // Main method for quick testing
    // =============================
    public static void main(String[] args) {
        // Example: unweighted undirected graph
        int[][] edges = {{0,1},{0,2},{1,3},{2,3},{3,4}};
        List<List<Integer>> g = buildAdjList(5, edges, false);

        System.out.println("BFS from 0:");
        bfs(g, 0);

        System.out.println("DFS from 0:");
        boolean[] vis = new boolean[g.size()];
        dfs(g, 0, vis);
        System.out.println();

        System.out.println("Topological sort (directed):");
        int[][] dirEdges = {{0,1},{0,2},{1,3},{2,3},{3,4}};
        List<List<Integer>> dg = buildAdjList(5, dirEdges, true);
        System.out.println(topoSort(dg));

        // Example: weighted directed graph for Dijkstra
        int[][] wEdges = {{0,1,4},{0,2,2},{1,2,5},{1,3,10},{2,4,3},{4,3,4}};
        List<List<Edge>> wg = buildWeightedAdjList(5, wEdges, true);
        long[] dist = dijkstra(wg, 0);
        System.out.println("Dijkstra distances from node 0:");
        System.out.println(Arrays.toString(dist));

        // Example: Union-Find
        DSU dsu = new DSU(5);
        dsu.union(0,1);
        dsu.union(1,2);
        System.out.println("Find(2): " + dsu.find(2));
        System.out.println("Find(3): " + dsu.find(3));
    }
}