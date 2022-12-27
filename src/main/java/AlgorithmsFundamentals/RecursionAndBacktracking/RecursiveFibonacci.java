package AlgorithmsFundamentals.RecursionAndBacktracking;

import java.util.Scanner;

public class RecursiveFibonacci {

    //достъпваме го отвсякъде когато е public,
    // запазваме в паметта изчислените по напред стойности
    public static long[] memorizationFib;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        memorizationFib = new long[N + 1];

        System.out.println(getFibonacci(N));
    }

    private static long getFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        // връщаме си изчислената стойност ако я имаме в паметта
        if (memorizationFib[n] != 0) {
            return memorizationFib[n];
        }

        //ако го нямаме го изчисляваме
        return memorizationFib[n] = getFibonacci(n - 2) + getFibonacci(n - 1);
    }
}

