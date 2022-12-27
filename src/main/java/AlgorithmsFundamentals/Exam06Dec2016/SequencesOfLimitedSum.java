package AlgorithmsFundamentals.Exam06Dec2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequencesOfLimitedSum {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int targetSum = Integer.parseInt(reader.readLine());
        int [] variations = new int [targetSum];

        getSequences(0, 0, targetSum, variations);
        System.out.println(stringBuilder.toString().trim());
    }

    private static void getSequences(int index, int currentSum, int targetSum, int[] variations) {
        if(currentSum <= targetSum && currentSum != 0){
            for (int i = 0; i < variations.length; i++) {
                int variation = variations[i];
                if(variation != 0){
                    stringBuilder = stringBuilder
                            .append(String.join(" ",
                                    String.valueOf(variation)));
                }
            }
            stringBuilder.append(System.lineSeparator());
        }

        if(currentSum >= targetSum){
            return;
        }

        for (int i = 1; i <= targetSum ; i++) {
            variations[index] = i;
            getSequences(index + 1,currentSum + i, targetSum, variations);
            variations[index] = 0;
        }
    }
}
