
public class Lesson {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 2};
        int[] arr1 = new int[]{1, 3};
        int[] arr2 = mergeArrays(arr, arr1);
        for (int r : arr2) {
            System.out.println(r);
        }
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int i = 0, j = 0, r = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                result[r] = a1[i];
                i++;
            } else {
                result[r] = a2[j];
                j++;
            }
            r++;
        }
        if (i < a1.length) {
            System.arraycopy(a1, i, result, r, (a1.length - i));
        }
        if (j < a2.length) {
            System.arraycopy(a2, j, result, r, (a2.length - j));
        }
        return result;

    }
}



