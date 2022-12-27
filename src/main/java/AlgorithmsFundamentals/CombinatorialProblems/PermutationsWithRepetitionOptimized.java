package AlgorithmsFundamentals.CombinatorialProblems;
/*
input:
5, 5, 1, 5, 5
output:
1 5 5 5 5
5 1 5 5 5
5 5 1 5 5
5 5 5 1 5
5 5 5 5 1
 */

import java.util.Arrays;
import java.util.Scanner;

public class PermutationsWithRepetitionOptimized {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] elements = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(elements);

        permuteRep(elements, 0, elements.length - 1);
    }

    static void permuteRep(int[] arr, int start, int end) {
        print(arr);
        for (int left = end - 1; left >= start; left--) {
            for (int right = left + 1; right <= end; right++) {
                if (arr[left] != arr[right]) {
                    swap(arr, left, right);
                    permuteRep(arr, left + 1, end);
                }
            }

            int firstElement = arr[left];
            for (int i = left; i <= end - 1; i++) {
                arr[i] = arr[i + 1];
                arr[end] = firstElement;
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
