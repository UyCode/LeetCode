package org.uycode.p._2001_3000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 22/06/2025 23:03:39
 */

public class P2138 {

    public static void main(String[] args) {
        System.out.println(divideString("abcdefghij", 3,  'x'));
    }

    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();

        String[] ans = new String[(n + k - 1) / k];

        for (int i = 0; i < n; i += k) {

            if (i + k <= n) {

                ans[i / k] = s.substring(i, i + k);

            } else {

                ans[i / k] = s.substring(i) + String.valueOf(fill).repeat(k - n + i);

            }

        }

        return ans;

    }
}
