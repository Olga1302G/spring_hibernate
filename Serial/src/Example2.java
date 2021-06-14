import java.util.*;

public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Object> deque = new ArrayDeque<>();
        int count = 1;
        while (scanner.hasNext()) {
            int is = scanner.nextInt();
            if (count % 2 == 0) {
                deque.add(is);
            }
            count++;

        }


        Iterator iterator = deque.descendingIterator();
        for (int i = 0; i < deque.size(); i++) {

            System.out.print(iterator.next() + " ");

        }

    }
}
