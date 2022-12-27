package AlgorithmsFundamentals.RecursionAndBacktracking;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        long iterFactorial = 1;
        for (int i = 1; i <= n; i++) {
           iterFactorial *= i;
        }

        System.out.println(iterFactorial);

        long result = recursiveFactorial(n);
        System.out.println(result);
    }

    private static long recursiveFactorial(int n) {
        if(n == 1){
            return 1;
        }

        return n * recursiveFactorial(n - 1);
    }
}
