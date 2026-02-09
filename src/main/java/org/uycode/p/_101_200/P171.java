package org.uycode.p._101_200;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 31/01/2026 23:12:14
 *
 */

public class P171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String columnTitle) {

        char[] chars = columnTitle.toCharArray();

        int sum = 0;

        for (char c : chars) {
            sum = sum * 26 + (c - 'A' + 1);
        }

        return sum;
    }
}
