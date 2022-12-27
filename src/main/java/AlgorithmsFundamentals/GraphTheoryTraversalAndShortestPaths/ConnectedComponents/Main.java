package AlgorithmsFundamentals.GraphTheoryTraversalAndShortestPaths.ConnectedComponents;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
//    public static class Edge{
//        public int source;
//        public int destination;
//
//        public Edge(int source, int destination) {
//            this.source = source;
//            this.destination = destination;
//        }
//    }

    public static void main(String[] args) {

//        new Edge(1,3);

        List<List<Integer>> graph = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numberOfLinesN = Integer.parseInt(scanner.nextLine());

        while (numberOfLinesN-- > 0) {
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
        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);


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
                dfs(i, graph, components, visited);
            }
        }

        return components;
    }

    private static void dfs(int node, List<List<Integer>> graph, List<Deque<Integer>> components, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            for (int child : graph.get(node)) {
                dfs(child, graph, components, visited);
            }
            components.get(components.size() - 1).offer(node);
        }
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {

        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {
            String key = graph.keySet().stream()
                    .filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if (key == null) {
                break;
            }

            for (String child : graph.get(key)) {
                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
            }

            sorted.add(key);
            graph.remove(key);
        }
        if (!graph.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);
            for (String child : node.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) + 1);
            }
        }
        return dependenciesCount;
    }
}
