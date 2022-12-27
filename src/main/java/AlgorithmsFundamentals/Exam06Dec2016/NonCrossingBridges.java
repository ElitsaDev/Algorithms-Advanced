package AlgorithmsFundamentals.Exam06Dec2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonCrossingBridges {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] seq = Arrays.stream(reader.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] bridgesCount = calcBridgesCount(seq);
        int maxCount = Arrays.stream(bridgesCount).max().orElse(-1);
        if (maxCount == 0) {
            System.out.println("No bridges found");
        } else if (maxCount == 1) {
            System.out.println("1 bridge found");
        } else {
            System.out.printf("%d bridges found%n", maxCount);
        }

        String bridges = reconstructBridges(seq, bridgesCount);
        System.out.println(bridges);
    }


    private static int[] calcBridgesCount(int[] seq) {
        int[] bridgeCounts = new int[seq.length];
        Map<Integer, Integer> prev = new LinkedHashMap<>();
        for (int index = 0; index < seq.length; index++) {
            if (index > 0) {
                bridgeCounts[index] = bridgeCounts[index - 1];
            }
            int currentNum = seq[index];
            if (prev.containsKey(currentNum)) {
                int prevIndex = prev.get(currentNum);
                if (bridgeCounts[prevIndex] + 1 > bridgeCounts[index]) {
                    // Better bridge count ending at position index found
                    bridgeCounts[index] = bridgeCounts[prevIndex] + 1;
                }
            }
            prev.put(currentNum, index);
        }
        return bridgeCounts;
    }

    private static String reconstructBridges(int[] seq, int[] bridgesCount) {
        String[] bridges = new String[seq.length];
        for (int i = 0; i < seq.length; i++) {
            bridges[i] = "X";
        }
        Map<Integer, Integer> prev = new LinkedHashMap<>();
        int bridgeNum = 0;
        for (int i = 0; i < seq.length; i++) {
            if (bridgeNum < bridgesCount[i]) {
                // Bridge found --> connect it
                int bridgeEnd = i;
                int bridgeStart = prev.get(seq[bridgeEnd]);
                bridges[bridgeStart] = String.valueOf(seq[i]);
                bridges[bridgeEnd] = bridges[bridgeStart];
                bridgeNum = bridgesCount[i];
            }
            prev.put(seq[i], i);
        }

        String allBridges = String.join(" ", bridges);
        return allBridges;
    }
}
