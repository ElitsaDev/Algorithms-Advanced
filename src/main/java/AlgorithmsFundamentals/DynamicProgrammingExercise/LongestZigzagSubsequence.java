package AlgorithmsFundamentals.DynamicProgrammingExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class LongestZigzagSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[sequence.length + 1][2];
        int[][] prev = new int[sequence.length + 1][2];

        int[] best = new int[2];

        //Are Greater
        dp[0][0] = 1;
        //Are Lower
        dp[0][1] = 1;

        //prev държи индексите
        prev[0][0] = -1;
        prev[0][1] = -1;

        int maxLength = 0;

        for (int i = 0; i < sequence.length; i++) {
            int currentNumber = sequence[i];
            for (int j = i - 1; j >= 0; j--) {
                int prevNumber = sequence[j];
                if (currentNumber > prevNumber && dp[i][0] <= dp[j][1] + 1) {
                    dp[i][0] = dp[j][1] + 1;
                    prev[i][0] = j;
                }

                if (currentNumber < prevNumber && dp[i][1] <= dp[j][0] + 1) {
                    dp[i][1] = dp[j][0] + 1;
                    prev[i][1] = j;
                }
            }

            if (maxLength < dp[i][0]) {
                maxLength = dp[i][0];
                best[0] = i;
                best[1] = 0;

            } else if (maxLength < dp[i][1]) {
                maxLength = dp[i][1];
                best[0] = i;
                best[1] = 1;
            }
        }

        Deque<Integer> zigZadSequence = new ArrayDeque<>();
        int beginRow = best[0];
        while (beginRow >= 0) {
            zigZadSequence.push(sequence[beginRow]);
            beginRow = prev[beginRow][best[1]];
            best[1] = best[1] == 0 ? 1 : 0;
        }

        while (!zigZadSequence.isEmpty()){
            System.out.print(zigZadSequence.pop() + " ");
        }
    }
}
