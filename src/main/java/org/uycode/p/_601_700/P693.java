package org.uycode.p._601_700;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 18/02/2026 11:39:44
 *
 */

public class P693 {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(11));
    }

    public static boolean hasAlternatingBits(int n) {


        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) return false;
        }

        return true;

    }
}
