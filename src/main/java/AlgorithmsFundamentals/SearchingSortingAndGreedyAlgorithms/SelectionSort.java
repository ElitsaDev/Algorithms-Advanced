package AlgorithmsFundamentals.SearchingSortingAndGreedyAlgorithms;
//O(n^2) , unstable
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {

        int [] arr = {5, 4, -1, 15, 0, 7, 25};

        sort(arr);

        for (int i:arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[index]){ // ако обърнем знака ги получаваме в reversed order
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
