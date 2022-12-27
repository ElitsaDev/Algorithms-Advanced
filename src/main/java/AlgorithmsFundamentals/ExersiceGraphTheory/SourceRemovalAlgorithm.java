package AlgorithmsFundamentals.ExersiceGraphTheory;

import java.util.*;
// topologicalSort();
public class SourceRemovalAlgorithm {
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
//A B E D C F
//0 1 4 3 2 5
        graph.add(0, List.of(1, 2)); //A -> B,C
        graph.add(1, List.of(3, 4)); //B -> D,E
        graph.add(2, List.of(5));    //C -> F
        graph.add(3, List.of(2, 5)); //D -> C,F
        graph.add(4, List.of(3));    //E -> D
        graph.add(5, List.of());     //F

      //Calculate the predecessors
      // създаваме си матрица, с размер общия брой nodes,
      // в която ще попълваме от кои node-ове зависи текущия node
       int[] predecessorsCount = new int[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            List<Integer> temp
                    = graph.get(i); // temp взима общия брой на child-овете на текущия node
            for (int node : temp) { // за всеки child, който срещне всеки път добавя + 1
                predecessorsCount[node]++;
            }
        }

        boolean[] isRemoved = new boolean[graph.size()];
        List<Integer> removedNodes = new ArrayList<>();
        boolean nodeRemoved = true;

        while (nodeRemoved) {
            nodeRemoved = false;
            for (int node = 0; node < graph.size(); node++) {
                if (predecessorsCount[node] == 0 && !isRemoved[node]) {
                    for (var childNode : graph.get(node)) {
                        predecessorsCount[childNode]--;
                    }
                    isRemoved[node] = true;
                    removedNodes.add(node);
                    nodeRemoved = true;
                    break;
                }
            }
        }

        if (removedNodes.size() == graph.size()) {
            for (var i:removedNodes) {
                System.out.print(i + " ");
            }

        } else { // Check if there was a cycle
            System.out.println("Cycle detected in graph");
        }
    }
}
