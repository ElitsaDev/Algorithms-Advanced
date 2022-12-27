package AlgorithmsFundamentals.DynamicProgramming;
//40/100

import java.util.*;

public class MoveDownRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dpMatrix = new int[rows][cols];
        dpMatrix[0][0] = matrix[0][0];

        for (int col = 1; col < matrix.length; col++) {
            dpMatrix[0][col] = dpMatrix[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < matrix.length; row++) {
            dpMatrix[row][0] = dpMatrix[row - 1][0] + matrix[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dpMatrix[row][col] = Math.max(dpMatrix[row - 1][col] + matrix[row][col],
                        dpMatrix[row][col - 1] + matrix[row][col]);
            }
        }

        List<String> path = new ArrayList<>();
        int row = rows - 1;
        int col = cols - 1;

        path.add(formatOutput(row, col));

        while (row > 0 || col > 0) {
            int top = -1;

            if (row > 0) {
                top = dpMatrix[row - 1][col];
            }

            int left = -1;
            if (col > 0) {
                left = dpMatrix[row][col - 1];
            }

            if (top > left) {
                row--;
            } else {
                col--;
            }

            path.add(formatOutput(row, col));
        }

        Collections.reverse(path);
        System.out.println(String.join(" ", path));
    }

    private static String formatOutput(int row, int col) {
        return "[" + row + ", " + col + "]";
    }
}
