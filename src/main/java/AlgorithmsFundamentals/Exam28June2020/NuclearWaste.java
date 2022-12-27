package AlgorithmsFundamentals.Exam28June2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NuclearWaste {
    public static int [] costOfFlasksTransport;
    public static int numberOfFlasksToTransport;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        costOfFlasksTransport = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        numberOfFlasksToTransport = Integer.parseInt(reader.readLine());

        int[] dp = new int[numberOfFlasksToTransport + 1];
        int[] prev = new int[numberOfFlasksToTransport + 1];

        for (int i = 1; i <= numberOfFlasksToTransport; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (j > costOfFlasksTransport.length) {
                    break;
                }
                int newValue = dp[i - j] + costOfFlasksTransport[j - 1];
                if (newValue < dp[i]) {
                    dp[i] = newValue;
                    prev[i] = j;
                }
            }
        }
        StringBuilder out = new StringBuilder();

        out.append("Cost: ")
                .append(dp[numberOfFlasksToTransport])
                .append(System.lineSeparator());

        while (numberOfFlasksToTransport > 0) {
            out.append(prev[numberOfFlasksToTransport])
                    .append(" => ")
                    .append(costOfFlasksTransport[prev[numberOfFlasksToTransport] - 1])
                    .append(System.lineSeparator());
            numberOfFlasksToTransport -= prev[numberOfFlasksToTransport];
        }
        System.out.println(out.toString());
    }
}
