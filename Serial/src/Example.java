import java.io.*;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class Example {
    public static void main(String[] args) throws IOException {

        byte myByte = -126; // 11111101

        byte[] myArray = {myByte};
        InputStream in = new ByteArrayInputStream(myArray);

        int myInt = in.read();
        System.out.println(myInt);

    }
    public static class Box <T> {
        private T object;

        Box() {
            this.object = object;
        }

        public static <T> Box <T> getObject() {
            return new Box <T> ();
        }
        //твой код здесь
    }
    public static class Pair <T1, T2> {
        private T1 first;
        private T2 second;
        private Pair  (T1 first, T2 second){
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() {
            if (first == null) {
                throw new NoSuchElementException("No value present");
            }
            return first;
        }

        public T2 getSecond() {
            if (second == null) {
                throw new NoSuchElementException("No value present");
            }
            return second;
        }
        public static <T1, T2> Pair<T1, T2> of(T1 value1, T2 value2 ) {
            return new Pair<>(value1, value2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

}
