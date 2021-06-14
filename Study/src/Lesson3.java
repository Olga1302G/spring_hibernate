import java.math.BigInteger;

public class Lesson3 {
    public static void main(String[] args) {


    }

    public static BigInteger factorial(int value) {
        if (value <= 1) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(value).multiply(factorial(value - 1));
        }
    }
}
