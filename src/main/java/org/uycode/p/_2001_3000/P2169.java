package org.uycode.p._2001_3000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 10/02/2026 10:54:52
 *
 */

public class P2169 {

    public static void main(String[] args) {
        System.out.println(countOperations(2, 3));
    }

    public static int countOperations(int num1, int num2) {
        int cnt = 0;

        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            cnt++;
        }

        return cnt;
    }
}
