import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exmp3 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
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
        }).limit(10).forEach(e -> System.out.println(e.getKey()));

    }
}

