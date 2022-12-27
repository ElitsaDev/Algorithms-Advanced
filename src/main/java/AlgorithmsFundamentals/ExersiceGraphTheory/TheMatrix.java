package AlgorithmsFundamentals.ExersiceGraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheMatrix {
    public static char[][] matrix;

    public static void main(String[] args) throws IOException {

        var reader = new BufferedReader(new InputStreamReader(System.in));
        int[] matrixSize = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int R = matrixSize[0];
        int C = matrixSize[1];

        matrix = new char[R][C];

        for (int i = 0; i < R; i++) {
            String[] line = reader.readLine().split("\\s+");
            for (int j = 0; j < C; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }

        char fillChar = reader.readLine().charAt(0);
        int[] coordinates = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startRow = coordinates[0];
        int startCol = coordinates[1];

        char toBeReplaced = matrix[startRow][startCol];
        dfs(startRow, startCol, fillChar, toBeReplaced);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void dfs(int row, int col, char fillChar, char toBeReplaced) {
        if (isOutOfBounds(row, col) || matrix[row][col] != toBeReplaced) {
            return;
        }
        matrix[row][col] = fillChar;

        dfs(row, col + 1, fillChar, toBeReplaced);
        dfs(row, col - 1, fillChar, toBeReplaced);
        dfs(row + 1, col, fillChar, toBeReplaced);
        dfs(row - 1, col, fillChar, toBeReplaced);
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length
                || col < 0 || col >= matrix[row].length;
    }
}
