package org.uycode.p._901_1000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 08/05/2025 13:36:01
 */

public class P926 {

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncrement("10011111110010111011"));
    }

    public static int minFlipsMonoIncrement(String s) {

        char[] cs = s.toCharArray();
        int n = s.length();
        int res = 0, curOneCnt = 0;
        for (int i = 0; i < n; i ++ ) {
            if (cs[i] == '1') {
                curOneCnt ++ ;
            } else {
                res = Math.min(res + 1, curOneCnt);
            }
        }
        return res;

    }
}
