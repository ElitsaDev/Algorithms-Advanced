package AlgorithmsFundamentals.ExamPreparation;

import java.util.*;

public class Molecules {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moleculesN = Integer.parseInt(scanner.nextLine());
        int connectionsM = Integer.parseInt(scanner.nextLine());

        int [][] graph = new int[moleculesN + 1][moleculesN + 1];

        for (int i = 0; i < connectionsM; i++) {
            int [] paths = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph[paths[0]][paths[1]] = 1;
        }

        int startMoleculeNumber = Integer.parseInt(scanner.nextLine());

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(startMoleculeNumber);
        boolean [] visited = new boolean[moleculesN + 1];

        while (!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            for (int i = 0; i < graph[node].length; i++) {
                if(graph[node][i] != 0 && !visited[i]){
                    queue.offer(i);
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if(!visited[i]){
                System.out.print(i + " ");
            }
        }
    }
}
