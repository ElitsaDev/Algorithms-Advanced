package AlgorithmsFundamentals.AExam;

import java.util.*;
import java.util.stream.Collectors;

public class Paths {
    public static List<Deque<Integer>> connectedComponents;
    public static boolean[] visited;

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String line = scanner.nextLine();

            if (line.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> nextNodes = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(nextNodes);
            }
        }


       connectedComponents = getConnectedComponents(graph);

        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.printf("Connected component:");

            for (int integer : connectedComponent) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }

    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                components.add(new ArrayDeque<>());
                dfs(i, graph);
            }
        }
        
        return components;
    }

    private static void dfs(int node, List<List<Integer>> graph) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(node);

        boolean isNotFound = true;

    /*    while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            if (isNotFound) {
                path.add(node);
                isNotFound = node != destination;
            }
            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }*/
    }
}
