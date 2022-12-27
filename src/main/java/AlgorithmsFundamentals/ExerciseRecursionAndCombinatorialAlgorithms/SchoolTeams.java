package AlgorithmsFundamentals.ExerciseRecursionAndCombinatorialAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolTeams {
    public static String[] girls;
    public static String[] boys;
    public static String[] elementsGirls;
    public static String[] elementsBoys;
    public static List<String> allGirls = new ArrayList<>();
    public static List<String> allBoys = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        girls = scanner.nextLine().split(", ");

        boys = scanner.nextLine().split(", ");


        elementsGirls = new String[3];
        elementsBoys = new String[2];

        combinedGirls(0, 0);
        combinedBoys(0, 0);

        for (String girls : allGirls) {
            for (String boys : allBoys) {
                System.out.println(girls + ", " + boys);
            }
        }
    }

    private static void combinedGirls(int index, int start) {
        if (index == elementsGirls.length) {
            allGirls.add(String.join(", ", elementsGirls));
        } else {

            for (int i = start; i < girls.length; i++) {
                elementsGirls[index] = girls[i];
                combinedGirls(index + 1, i + 1);//само по това се различава
            }
        }
    }

    private static void combinedBoys(int index, int start) {
        if (index == elementsBoys.length) {
            allBoys.add(String.join(", ", elementsBoys));
        } else {

            for (int i = start; i < boys.length; i++) {
                elementsBoys[index] = boys[i];
                combinedBoys(index + 1, i + 1);//само по това се различава
            }
        }
    }
}
