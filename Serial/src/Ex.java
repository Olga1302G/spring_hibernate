import java.util.*;
import java.util.function.UnaryOperator;

class Ex {
    public Ex() {
    }
}

class Bar extends Ex {
    public Bar() {
    }
}

class Baz<T> {
    public T object;
    public UnaryOperator<Integer> sqrt() {
        return sqrt();//Твой код здесь
    }
    public Baz(T object) {
        this.object = object;
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Object> deque = new ArrayDeque<>();
        int count = 1;
        while (scanner.hasNext()) {
            int is = scanner.nextInt();
            if (count % 2 == 0) {
                deque.addFirst(is);
            }
            count++;

        }
        for (Object e : deque) {
            System.out.print(e + " ");
        }
    }




}

