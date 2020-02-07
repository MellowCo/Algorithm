package algorithm.kmp;

import java.util.Arrays;

/**
 * @Description: kmp
 * @Author: li
 * @Create: 2020-02-07 13:02
 */
public class Kmp {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        // Kmp.violent(str1, str2);
        System.out.println(Arrays.toString(Kmp.kmpArr(str2)));
        Kmp.kmp(str1, str2);
    }

    //暴力破解
    public static void violent(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int i = 0;
        int j = 0;

        while (i < c1.length && j < c2.length) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == c2.length) {
            System.out.println("index=" + (i - j));
        } else {
            System.out.println("null");
        }
    }

    public static int[] kmpArr(String str2) {
        int[] arr = new int[str2.length()];
        int i = 0, j = -1;
        arr[0] = -1;
        char[] c = str2.toCharArray();

        while (i < c.length - 1) {
            if (j == -1 || c[i] == c[j]) {
                i++;
                j++;
                arr[i] = j;
            } else {
                j = arr[j];
            }
        }
        return arr;
    }

    public static void kmp(String str1, String str2) {

        int[] next = kmpArr(str2);

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int i = 0;
        int j = 0;

        while (i < c1.length && j < c2.length) {
            if (j == -1 || c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == c2.length) {
            System.out.println("index = " + (i - j));
        }

    }
}
