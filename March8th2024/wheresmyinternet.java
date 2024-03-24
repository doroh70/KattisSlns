package March8th2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class wheresmyinternet {
    private static Set<Integer> unvisited;
    private static Map<Integer, Set<Integer>> adjList;

    static int N, M;

    public static void buildAdjList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new HashMap<>();
        unvisited = new HashSet<>();

        for(int i = 1; i <= N; i++){
            unvisited.add(i);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //Check if there is already a list for node a
            Set<Integer> set = adjList.getOrDefault(a, new HashSet<>());
            set.add(b);
            adjList.put(a, set);

            //Building bidirectional so do other way around
            Set<Integer> setB = adjList.getOrDefault(b, new HashSet<>());
            setB.add(a);
            adjList.put(b, setB);
        }
    }

    public static void main(String[] args) throws IOException {
        buildAdjList();
        DFS(1);

        if (!unvisited.isEmpty()) {
            List<Integer> sortedUnvisited = new ArrayList<>(unvisited);
            Collections.sort(sortedUnvisited);
            for (int node : sortedUnvisited) {
                System.out.println(node);
            }
        } else {
            System.out.println("Connected");
        }
    }

    public static void DFS(int start) {
        if (!unvisited.contains(start)) {
            return; // If the node is already visited (not in unvisited), return
        }
        unvisited.remove(start); // Mark the node as visited by removing it from unvisited

        for (int neighbor : adjList.getOrDefault(start, Collections.emptySet())) {
            DFS(neighbor);
        }
    }
}