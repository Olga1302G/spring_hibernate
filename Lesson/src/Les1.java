public class Les1 {
    public static void main(String[] args) {
        int[] v = new int[]{3, 5, 20, 8, 7, 3, 100};
        printOddNumbers(v);
    }

    public static void printOddNumbers(int[] arr) {
        StringBuilder massiv = new StringBuilder("");
        for (int j : arr) {
            if (j % 2 != 0) {
                massiv.append(j + ",");

            }
        }
        if (massiv.length() != 0) {
            massiv.deleteCharAt(massiv.length() - 1);
        }
        System.out.println(massiv);//Твой код здесь
    }

}
