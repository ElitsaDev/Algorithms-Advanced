package AlgorithmsFundamentals.GraphTheoryTraversalAndShortestPaths.ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ShortestPath {
    public static boolean[] visited;
    public static int[] previousNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> graph = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String line = reader.readLine();

            if (line.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> nextNodes = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(nextNodes);
            }
        }

        int destination = graph.size()- 1;

        visited = new boolean[graph.size() + 1];
        previousNodes = new int[graph.size() + 1];

        Arrays.fill(previousNodes,-1);

        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int i = 0; i <= graph.size(); i++) {
          dfs(i, components,graph, visited);
        }

        List<Integer> path = new ArrayList<>();
        path.add(destination);

        int prevNode = previousNodes[destination];

        while (prevNode != -1){
            path.add(prevNode);
            prevNode = previousNodes[prevNode];
        }
        System.out.println(path);
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            for (int child : graph.get(node)) {
                dfs(child, components, graph, visited);
            }
            components.get(components.size() - 1).offer(node);
        }
    }
}
