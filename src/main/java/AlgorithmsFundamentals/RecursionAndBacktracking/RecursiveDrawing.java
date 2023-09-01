package AlgorithmsFundamentals.RecursionAndBacktracking;

import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        drawingFigure(n);
    }

    private static void drawingFigure(int n) {
        if(n == 0){
            return;
        }

        //Pre-action
        drawRowWithSymbols(n, "*");

        drawingFigure(n - 1);

        //Post-action
        drawRowWithSymbols(n, "#");
    }

    private static void drawRowWithSymbols(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
        System.out.println();
    }
}
