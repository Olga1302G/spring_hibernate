import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Example1 {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);

        HashSet<Integer> s2 = new HashSet<>();
        s2.add(4);
        s2.add(1);
        s2.add(2);

        Set<Integer> result = symmetricDifference(s1,s2);
        System.out.println(result);
    }
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set = new HashSet<>(set1);
        Set <T> set3 = new HashSet<>(set2);
        set.removeAll(set3);
        set3.removeAll(set1);
        set.addAll(set3);
        return set;//твой код здесь
    }
}
