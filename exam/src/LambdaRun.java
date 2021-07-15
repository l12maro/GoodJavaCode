import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaRun {
    public static void main(String[] args){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("bbbb");
        arrayList.add("aaaa");
        arrayList.add("aa");
        arrayList.add("aaa");

        // Sort the array by length of the string (from shorter to longer)
        // Equivalent to .sort((s1, s2) -> Integer.compare(s1.length(), s2.length()))
        arrayList.sort(Comparator.comparingInt(String::length));
        for (String s: arrayList){
            System.out.println(s);
        }

        // Sort the array by length of the string (from longer to shorter)
        arrayList.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));
        for (String s: arrayList){
            System.out.println(s);
        }
        
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(5);
        arrayList2.add(10);
        arrayList2.add(2);
        arrayList2.add(103);
        arrayList2.add(4);

        // Sort array of Integers from smaller to bigger
        // Equivalent to .sort((x, y) -> x.compareTo(y))
        arrayList2.sort(Integer::compareTo);

        for (Integer i: arrayList2){
            System.out.println(i);
        }

        // Sort array of Integers from bigger to smaller
        arrayList2.sort((x, y) -> {
            return y.compareTo(x);
        });

        for (Integer i: arrayList2){
            System.out.println(i);
        }

    }
}
