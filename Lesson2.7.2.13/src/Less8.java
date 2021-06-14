import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Less8 {
    public static void main(String[] args) {

        Map <String, Long> map = (new BufferedReader(new InputStreamReader(System.in)))
                 .lines()
                 .flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]+")))
                 .map(n -> n.toLowerCase(Locale.ROOT))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue)
                .reversed())
                .map(n->n.getKey()).limit(10)
                .forEach(System.out::println);

    }}
/*HashMap<String, Integer> map = new HashMap<>();
    (new BufferedReader(new InputStreamReader(System.in)))
                .lines()
                .flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]+")))
                .map(n -> n.toLowerCase(Locale.ROOT))
                .forEach(n -> {
                    if (map.containsKey(n)) {
                        map.put(n, map.get(n) + 1);
                    } else {
                        map.put(n, 1);
                    }
                });
    map.entrySet().stream().sorted((e1, e2) -> {
        if (e1.getValue() == e2.getValue()) {
            return e1.getKey().compareTo(e2.getKey());
        } else {
            return e2.getValue().compareTo(e1.getValue());
        }
    }).limit(10).forEach(e -> System.out.println(e.getKey()));//Твой код здесь
}*/