import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exmp1 {
    @FunctionalInterface
    interface NumberGenerator<T extends Number> {
        boolean cond(T arg);
    }

    public static NumberGenerator<? super Number> getGenerator() {
        return x -> x.intValue() > 0;// и здесь
    }

    public static void main(String[] args) {
        System.out.println(getGenerator().cond(-2));
        Predicate<Object> condition = obj1 -> Objects.isNull(obj1);
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = charSequence -> charSequence.length();
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply("Hello"));
        System.out.println(safeStringLength.apply(null));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return (x) -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);//Твой код здесь
    }

}
