package AlgorithmsFundamentals.AExam;
//16/100
/*On the first line you will receive an integer – n – number of nodes.
On the next n lines, you will receive a list of children
for the nodes 0 … n - 1 (separated by a space).

input:
5
1
2 3
3
4
output:
0 1 2 3 4
0 1 3 4
1 2 3 4
1 3 4
2 3 4
3 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Paths01 {
    public static ArrayList<Integer> path;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> graph = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        int size = n;
        for (int i = 0; i < n; i++) {

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


        int targetVersion = graph.size() - 1;

        visited = new boolean[graph.size() + 1];
        path = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            dfs(graph, i, targetVersion);
        }


        StringBuilder out = new StringBuilder();
        for (Integer node : path) {
            out.append(node).append(" ");
        }
        out.append(System.lineSeparator());


        System.out.println(out.toString().trim());
    }

    private static void dfs(List<List<Integer>> graph, int source, int destination) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        boolean isNotFound = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            if (isNotFound) {
                path.add(node);
                isNotFound = node != destination;
            }
            for (int i = 0; i < graph.get(node).size(); i++) {
                if (graph.get(node).get(i) != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
