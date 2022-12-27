package AlgorithmsFundamentals.ExamPreparation;
//combinations Without Repetitions with recursion
import java.util.Arrays;
import java.util.Scanner;

public class MonkeyBusiness {
    public static int n;
    public static int countSolutions;
    public static int[] elements;

    public static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        elements = new int[n];
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        combinationsWithoutRepetitions(0);

        System.out.println("Total Solutions: " + countSolutions);
    }

    private static void combinationsWithoutRepetitions(int index) {
        if (index >= n) {
            print();
        } else {

            elements[index] = numbers[index];
            combinationsWithoutRepetitions(index + 1);
            elements[index] = -numbers[index];
            combinationsWithoutRepetitions(index + 1);
        }
    }

    private static void print() {
        int targetSum = Arrays.stream(elements).sum();

        if (targetSum == 0) {
            countSolutions++;
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] > 0) {
                    System.out.print("+" + elements[i] + " ");
                } else {
                    System.out.print(elements[i] + " ");
                }
            }
            System.out.println();
        }
    }
}