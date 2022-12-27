package AlgorithmsFundamentals.DynamicProgrammingExercise;

import java.util.*;

public class SumWithLimitedCoinsOptimized {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coins = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetSum = Integer.parseInt(scanner.nextLine());

        int possibleSum = CalcPossibleSum(coins, targetSum);

        System.out.print(possibleSum);
    }

    private static int CalcPossibleSum(int[] coins, int target) {
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        int count = 0;
//todo
        for (var number : coins) {
            Set<Integer> newSetSum = new HashSet<>();
            for (var sum : sums) {
                int newSum = sum + number;
                newSetSum.add(newSum);
                if (newSum == target) {
                    count += 1;
                }
            }
            sums.addAll(newSetSum);
        }
        return count;
    }
}
