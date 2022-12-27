package AlgorithmsFundamentals.CombinatorialProblems;

import java.util.Scanner;
/*
input:
A B C
output:
A B C
A C B
B A C
B C A
C B A
C A B
формулата е: n!
 */

//като итеративно решение трябва да знаем предварително броя на елементите,
// за да направим вложените цикли
//при рекурсивното - динамично се взима броя на елементите, може да се оптимизира
//като се използва Swap algorithm
public class PermutationsWithoutRepetition {
    public static String[] elements;
    public static String[] permutes;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");
        permutes = new String[elements.length];
        used = new boolean[elements.length];
        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print();
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if(!used[i]){
                used[i] = true;

            permutes[index] = elements[i];
            permute(index + 1);
            used[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", permutes));
    }
}
