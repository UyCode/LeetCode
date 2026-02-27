package org.uycode.p._3001_4000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 13/02/2026 11:57:47
 *
 */

public class P3461 {

    public static void main(String[] args) {
        System.out.println(hasSameDigits("48"));
    }

    public static boolean hasSameDigits(String s) {

        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int limit = n - 1; limit > 1; limit--) {
            for (int i = 0; i < limit; i++) {
                // Convert chars to ints, sum them, get last digit, convert back to char
                int sum = (chars[i] - '0') + (chars[i+1] - '0');
                chars[i] = (char) ((sum % 10) + '0');
            }
        }

        return chars[0] == chars[1];
    }
}
