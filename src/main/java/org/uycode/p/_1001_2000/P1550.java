package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/05/2025 12:22:05
 */

public class P1550 {

    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {

        int cursor =0;

        while (cursor < arr.length-2) {
            if (arr[cursor] % 2 ==0) {
                cursor++;
            } else {
                cursor++;
                if (arr[cursor] % 2 ==0) {
                    cursor++;
                } else {
                    cursor++;
                    if (arr[cursor] % 2 == 0) {
                        cursor++;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
