import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exmp2 {
    public static void main(String[] args) {
        IntStream res = pseudoRandomStream(13);
        res.limit(10).forEach(x -> System.out.print(x + " "));
    }

    public static IntStream pseudoRandomStream(int seed) {

        return IntStream.iterate(seed, n -> n * n / 10 % 1000);//твой код здесь
    }

    public <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size()));

        }

    }

}
