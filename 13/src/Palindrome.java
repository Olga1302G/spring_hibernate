public class Palindrome {
    public static void main(String[] args) {
        //String tr = "Was it a cat I saw?";
       // System.out.println(isPalindrome(tr));
        int red = 15;
        int black = 15;
        for (int i = 0; i < 100; i++) {
            red++;
            for (int j = 0; j < 5; j++) {
                red = red*2;
            }
        }
        for (int i = 0; i < 100; ) {
            black++;
            for (int j = 0; j < 5; j++) {
                black = black*2;
            }
            i++;
        }
        System.out.println("red = "+red+" black = "+black);
    }

    public static boolean isPalindrome(String text) {
        boolean palindrom;
        StringBuilder str = new StringBuilder(text);
        String text1 = str.reverse().toString().replaceAll("(?U)[\\pP\\s]", "").replace(" ", "");
        if (text1.equalsIgnoreCase(text.replaceAll("(?U)[\\pP\\s]", "").replace(" ", ""))) {
            palindrom = true;
        } else {
            palindrom = false;
        }
        return palindrom;//Твой код здесь
    }
}


