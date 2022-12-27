package AlgorithmsFundamentals.SearchingSortingAndGreedyAlgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffling {
    public static void main(String[] args) {
        int [] arr = {5, 4, 1, 15, 0, 7, 25};

        Arrays.sort(arr);

        getAsRand(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Implementing Fisher–Yates shuffle
    private static void  getAsRand(int[] arr) {

        Random rnd = ThreadLocalRandom.current();

        for (int i = arr.length - 1; i >= 0 ; i--) {
            int index = rnd.nextInt(i + 1);

            swap(arr,i, index);
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
