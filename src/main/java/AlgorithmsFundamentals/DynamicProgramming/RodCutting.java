package AlgorithmsFundamentals.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {
    public static int [] prices;
    public static int [] bestPrices;
    public static int [] prevIndex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        prices = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lengthRope = Integer.parseInt(scanner.nextLine());
        bestPrices = new int [lengthRope + 1];
        prevIndex = new int [lengthRope + 1];

        int maxProfit = cutRope(lengthRope);

        System.out.println(maxProfit);
        reconstructSolution(lengthRope);
    }

    private static int cutRope(int lengthRope) {
        if(lengthRope == 0){
            return 0;
        }

        if(bestPrices[lengthRope] != 0){
            return bestPrices[lengthRope];
        }

        int currentBest = bestPrices[lengthRope];

        for (int i = 1; i <= lengthRope; i++) {
            currentBest = Math.max(currentBest, prices[i] + cutRope(lengthRope - i));
            if(currentBest > bestPrices[lengthRope]){
                bestPrices[lengthRope] = currentBest;
                prevIndex[lengthRope] = i;
            }
        }
        return bestPrices[lengthRope];
    }

    private static void reconstructSolution(int length) {
        while (length - prevIndex[length] != 0) {
            System.out.print(prevIndex[length] + " ");
            length = length - prevIndex[length];
        }
        System.out.println(prevIndex[length]);
    }
}
