package AlgorithmsFundamentals.DynamicProgramming;
//не работи правилно при targetSum = 9
//задача от C# курса
//todo - сравни с другото решение
import java.util.*;

public class SubsetSum {
    public static void main(String[] args) {
        int[] numbers = {3, 5, -1, 10, 1, 20};
        int targetSum = 15;

       var possibleSum = CalcPossibleSum(numbers, targetSum);
       List<Integer> subset = reconstruct(numbers, targetSum, possibleSum);

       System.out.println(subset);
    }

    private static List<Integer> reconstruct(int[] nums, int targetSum, Map<Integer, Integer> possibleSum) {
        List<Integer> subset = new ArrayList<>();
        while (targetSum > 0){
            Integer lastNum = possibleSum.get(targetSum);
            subset.add(lastNum);
            targetSum -= lastNum;
        }

        Collections.reverse(subset);
        return subset;
    }

    public static Map<Integer,Integer> CalcPossibleSum(int[] nums, int targetSum){
        Map<Integer, Integer> possibleSums = new TreeMap<>();
        possibleSums.put(0, 0);//отправна точка

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            Map<Integer, Integer> newSums = new TreeMap<>();

            for (var sum:possibleSums.keySet()) {
                int newSum = sum + currentNum;
                newSums.putIfAbsent(newSum,currentNum);
            }

            for (var sum:newSums.entrySet()) {
                if(!possibleSums.containsKey(sum.getKey())){
                    possibleSums.put(sum.getKey(),sum.getValue());
                }
            }
        }
        return possibleSums;
    }
}
