package AlgorithmsFundamentals.AExam;
//мисля, че това е решението на задачата, но я реших след това
/*
input:
4, 5, 6
output:
4
5
6
4 5
4 6
5 6
4 5 6
*/
import java.util.Arrays;
import java.util.Scanner;

public class SuperSetArr {
    public static int [] array;
    public static String[] variations;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        array = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= array.length; i++) {
            variations = new String[i];
            combinations(0, 0);
        }
    }

    private static void combinations(int index, int start) {
        if (index == variations.length) {
            print(variations);
        }else {
            for (int i = start; i < array.length; i++) {
                variations[index] = String.valueOf(array[i]);
                combinations(index + 1, i + 1);
            }
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
