import java.io.*;
import java.nio.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        double summa = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    summa += Double.parseDouble(scanner.next());
                } else {
                    scanner.next();
                }
            }

            System.out.printf("%.6f", summa);
        } catch (Exception e) {
            System.out.printf("%.6f", 0);
        }
    }
}
