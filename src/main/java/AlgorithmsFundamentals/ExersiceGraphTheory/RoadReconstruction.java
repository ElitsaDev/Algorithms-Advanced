package AlgorithmsFundamentals.ExersiceGraphTheory;

import java.util.*;

public class RoadReconstruction {
    public static Map<String, List<String>> graph = new HashMap<>();
    private static Set<String> outputCycle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int buildingsAmount = Integer.parseInt(scanner.nextLine());
        int streetsAmount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < streetsAmount; i++) {

            String[] tokens = scanner.nextLine().split(" - ");
            String parent = tokens[0];
            String child = tokens[1];

            graph.putIfAbsent(parent,new ArrayList<>() );
            graph.get(parent).add(child);
        }

        while (true) {
            Set<String> visited = new HashSet<>();
            boolean noCycles = true;
            for (String node : graph.keySet()) {
                SortedSet<String> cycle = new TreeSet<>();
                outputCycle = new TreeSet<>();
                boolean cyclic = dfsSearchForCycles(node, visited, cycle, null);
                if (cyclic) {
                    noCycles = false;
                    graph.remove(node);
                    cyclic = dfsSearchForCycles(node, visited, cycle, null);


                    break;
                }
            }
            if (noCycles) {
                break;
            }
        }
        System.out.println("Important streets:");
       // System.out.print(output.toString());
    }

    private static boolean dfsSearchForCycles(String node, Set<String> visited, SortedSet<String> cycle, String parent) {
        boolean output = false;
        if (cycle.contains(node)) {
            outputCycle.addAll(cycle);
            return true;
        }

        if (!visited.contains(node)) {
            visited.add(node);
            cycle.add(node);
            if (graph.containsKey(node)) {
                for (String child : graph.get(node)) {
                    if (!child.equals(parent)) {
                        output = output || dfsSearchForCycles(child, visited, cycle, node);
                    }
                }
                cycle.remove(node);
            }
        }
        return output;
    }
}
