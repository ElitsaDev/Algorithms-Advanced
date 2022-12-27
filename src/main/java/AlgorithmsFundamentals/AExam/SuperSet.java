package AlgorithmsFundamentals.AExam;
//20/100
import java.util.Scanner;

public class SuperSet {
    public static String[] elements;
    public static int[] arr;
    public static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split(",\\s+");

        int n = elements.length;

        arr = new int[n];

        permute(0);
    }

    private static void permute(int index) {
        if (index == arr.length) {
            printArr();
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            permute(index + 1);
        }
    }

    private static void printArr() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

