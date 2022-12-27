package AlgorithmsFundamentals.DynamicProgrammingExercise;

import java.util.*;

public class SumWithLimitedCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coins = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetSum = Integer.parseInt(scanner.nextLine());

        Map<Integer, Integer> possibleSum = CalcPossibleSum(coins);

        System.out.print(possibleSum.get(targetSum));
    }

    private static Map<Integer, Integer> CalcPossibleSum(int[] coins) {
        Map<Integer, Integer> result = new TreeMap<>();
        result.putIfAbsent(0, 1);
        for (var number : coins) {
            Integer[] sums = result.keySet().toArray(new Integer[0]);
            for (var sum : sums) {
                int newSum = sum + number;
                if (!result.containsKey(newSum)) {
                    result.put(newSum, 1);
                }else{
                    result.put(newSum, result.get(newSum) + 1);
                }
            }
        }
        return result;
    }
}
