package AlgorithmsFundamentals.Exam04April2016Nakov;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
input:
3
1 -> 2 2
0 -> 1
2 -> 0
output:
{0 -> 1 -> 2}
 */
public class GraphCycles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int numberOfVertices = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfVertices; i++) {
            String[] tokens = scanner.nextLine().split( " -> ");
            int source = Integer.parseInt(tokens[0]);
            String line = String.valueOf(tokens[1]);

            List<Integer> children = Arrays.stream(line.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            graph.putIfAbsent(source, new ArrayList<Integer>());
            graph.put(source,children);
        }

        boolean cyclesFound = false;

        for (var nodeA:graph.keySet()) {
            Object[] arr = graph.get(nodeA).stream().filter(n -> n > nodeA).sorted().toArray();
            for (int i = 0; i < arr.length; i++) {
                int nodeB = (int) arr[i];
                Object[] arrB = graph.get(nodeB).stream().filter(n -> n > nodeA).sorted().toArray();
                for (int j = 0; j < arrB.length; j++) {
                    int nodeC = (int) arrB[j];
                    if (graph.get(nodeC).contains(nodeA) && nodeB != nodeC) {
                        System.out.printf("%d -> %d -> %d%n", nodeA, nodeB, nodeC);
                        cyclesFound = true;
                    }
                }
            }
        }

        if (!cyclesFound) {
            System.out.println("No cycles found");
        }
    }
}
