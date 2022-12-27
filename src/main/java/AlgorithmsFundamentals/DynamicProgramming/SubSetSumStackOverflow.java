package AlgorithmsFundamentals.DynamicProgramming;
//решение от StackOverflow - и с отрицателни числа,
// като вади всички субсети, които са решение
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//задача от C# курса
public class SubSetSumStackOverflow {
    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    public static int sumSet(Set<Integer> set){
        int sum =0;
        for (Integer s : set) {
            sum += s;
        }
        return sum;
    }

    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<Integer>();
        mySet.add(3);
        mySet.add(5);
        mySet.add(-1);
        mySet.add(10);
        mySet.add(1);
        mySet.add(20);

        int mySum = 9;
        for (Set<Integer> s : powerSet(mySet)) {
            if(mySum == sumSet(s))
                System.out.println(s + " = " + sumSet(s));
        }
    }
}
