import java.math.*;
import java.util.*;
import java.lang.*;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.*;
class Quiz {

    public static void main(String[] args) throws Exception {
        String a = "Was it a cat I saw?!";
        StringBuilder str = new StringBuilder(a);
        String c = str.reverse().toString().replace(",", "").replace(" ", "");
        //String c = a.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase();
        System.out.println(a.replace(",", "").replace(" ", ""));
        System.out.println(isPalindrome(a));
       // System.out.println(charExpression(2));
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 0.0001;
    }

    public static boolean isPalindrome(String text) {
        StringBuilder str = new StringBuilder(text);
        String text1 = str.reverse().toString().replaceAll("(?U)[\\pP\\s]", "").replace(" ", "").toLowerCase();
        Pattern pattern = Pattern.compile(text.replaceAll("(?U)[\\pP\\s]", "").replace(" ", "").toLowerCase(),Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text1);
        return matcher.find();//Твой код здесь
        }
    }


