package AlgorithmsFundamentals.Exam15May2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
input:
1 0 1 0 1
output:
1|01|01
1|010|1
10|1|01
10|10|1
 */
public class Medenka {
    static int[] medenka;
    static List<Integer> nutIndices = new ArrayList<>();
    static List<Integer> cuts = new ArrayList<>();
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        medenka = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < medenka.length; i++) {
            if (medenka[i] == 1) {
                nutIndices.add(i);
            }
        }

        if (nutIndices.size() == 1) {
            for (int i = 0; i < medenka.length; i++) {
                System.out.print(String.join(" ", String.valueOf(medenka[i])));
            }
        } else {
            GenerateMedenki(0);
        }

        System.out.println(output.toString().trim());
    }

    private static void GenerateMedenki(int p) {
        if (p == nutIndices.size() - 1) {
            Print();
            return;
        }

        var currentNutIndex = nutIndices.get(p);
        var nextNutIndex = nutIndices.get(p + 1);
        // Perform cut on each index between two nuts
        for (int i = currentNutIndex; i < nextNutIndex; i++) {
            cuts.add(i);
            GenerateMedenki(p + 1);
            cuts.remove(cuts.size() - 1);
        }
    }

    private static void Print() {
        var currentCut = 0;
        for (int i = 0; i < cuts.size(); i++) {
            // Append all elements before cut
            for (int j = currentCut; j < cuts.get(i) + 1; j++) {
                output.append(medenka[j]);
            }

            // Append cut
            output.append('|');
            currentCut = cuts.get(i) + 1;
        }

        // Add all 0s and 1s after last cut
        var lastCut = cuts.get(cuts.size() - 1);
        for (int i = lastCut + 1; i < medenka.length; i++) {
            output.append(medenka[i]);
        }
        output.append(System.lineSeparator());
    }
}
