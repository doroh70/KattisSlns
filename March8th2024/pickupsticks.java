package March8th2024;

import java.io.*;
import java.util.*;

public class pickupsticks {
    private static int n, m;
    private static Map<Integer, List<Integer>> adjList = new HashMap<>();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        //read n, m using BufferedReader
        st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //build adj matrix and simultaneously update in-degree
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>()); // Ensure all vertices are in the adjList
            inDegree.put(i, 0); // Initialize in-degrees
        }

        buildAdjList(inDegree); // Build adjacency list and update in-degree together

        //call top_sort method
        List<Integer> ans = TPS(inDegree); // Pass in-degree directly to TPS

        if (ans == null) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = 0; i < ans.size(); i++) {
                System.out.println(ans.get(i));
            }
        }
    }

    public static void buildAdjList(Map<Integer, Integer> inDegree) throws IOException {
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            inDegree.put(b, inDegree.getOrDefault(b, 0) + 1);
        }
    }

    public static List<Integer> TPS(Map<Integer, Integer> inDegree) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();
            order.add(current);

            for (int neighbor : adjList.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }
        }

        if (order.size() != n) {
            return null;
        }
        return order;
    }
}