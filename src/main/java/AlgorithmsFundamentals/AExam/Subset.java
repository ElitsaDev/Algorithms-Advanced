package AlgorithmsFundamentals.AExam;

import java.util.*;
import java.util.stream.Collectors;

public class Subset {


    public static void findSubsets(List<List<Integer>> subset, List<Integer> nums, List<Integer> output, int index) {
        // Base Condition
        if (index == nums.size()) {
            subset.add(output);
            return;
        }

        // Not Including Value which is at Index
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);

        // Including Value which is at Index
        output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Main List for storing all subsets
        List<List<Integer>> subset = new ArrayList<>();

        // Input ArrayList
        List<Integer> input = Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        findSubsets(subset, input, new ArrayList<>(), 0);

        // Comparator is used so that all subset get
        // sorted in ascending order of values
        Collections.sort(subset, (o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i)) {
                    continue;
                } else {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });

        List<String > out = new ArrayList<>();
        String str = "";
        // Printing Subset
        for (int i = 0; i < subset.size(); i++) {

            for (int j = 0; j < subset.get(i).size(); j++) {
                System.out.print(subset.get(i).get(j) + " ");
                str = subset.get(i).get(j) + " ";
                out.add(str);
            }
            //out.add(str);
            System.out.println();
        }

       // System.out.println(out);
    }
}