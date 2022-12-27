package AlgorithmsFundamentals.Exam04April2016Nakov;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
We are given n capital Latin letter.Generate all their permutations, so that
the same letters stay together.
Example: n=7, letters={B,C,A,B,A,C,B}
Result:
AABBBCC
AACCBBB
BBBAACC
BBBCCAA
CCAABBB
CCBBBAA
 */
public class GroupPermutations {
    public static Map<Character,Integer> lettersCount;
    public static char[] setOfAllLetters;

    public static void main(String[] args) {
        char [] input = "BCABACB".toCharArray();
        lettersCount = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            char letter = input[i];
            if(!lettersCount.containsKey(letter)){
                lettersCount.put(letter,1);
            }else {
                lettersCount.put(letter, lettersCount.get(letter) + 1);
            }
        }

        Set<Character> letters = lettersCount.keySet();
        setOfAllLetters = new char[letters.size()];
        AtomicInteger index = new AtomicInteger(0);

        letters.forEach(l-> setOfAllLetters[index.getAndIncrement()] = l);

        permute(0);
    }

    private static void permute(int index) {
        if (index == setOfAllLetters.length) {
            print(setOfAllLetters);
            return;
        }
        permute(index + 1);

        for (int i = index + 1; i < setOfAllLetters.length; i++) {
            swap(setOfAllLetters, index, i);
            permute(index + 1);
            swap(setOfAllLetters, index, i);
        }
    }

    private static void swap(char[] arr, int first, int second) {
        char temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print(char[] setOfAllLetters) {
        for (int i = 0; i < setOfAllLetters.length; i++) {
            char currentLetter = setOfAllLetters[i];
            int countLetter = lettersCount.get(currentLetter);
            for (int j = 0; j < countLetter; j++) {
                System.out.print(currentLetter);
            }
        }
        System.out.println();
    }
}
