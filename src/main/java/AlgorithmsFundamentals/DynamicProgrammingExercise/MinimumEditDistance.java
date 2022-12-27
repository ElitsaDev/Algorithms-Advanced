package AlgorithmsFundamentals.DynamicProgrammingExercise;

import java.util.Scanner;

public class MinimumEditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int replaceCost = Integer.parseInt(scanner.nextLine());
        int insertCost = Integer.parseInt(scanner.nextLine());
        int deleteCost = Integer.parseInt(scanner.nextLine());

        char[] first = scanner.nextLine().toCharArray();
        char[] second = scanner.nextLine().toCharArray();

        int[][] dp = new int[first.length + 1][second.length + 1];

        for (int i = 1; i <= first.length; i++) {
            dp[i][0] = dp[i - 1][0] + deleteCost;
        }

        for (int j = 1; j <= second.length; j++) {
            dp[0][j] = dp[0][j - 1] + insertCost;
        }

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    int delete = dp[i - 1][j] + deleteCost;
                    int insert = dp[i][j - 1] + insertCost;
                    int replace = dp[i - 1][j - 1] + replaceCost;
                    dp[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        System.out.print("Minimum edit distance: " + dp[first.length][second.length]);
    }
}
