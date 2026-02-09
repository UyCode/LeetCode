package org.uycode.p._1_100;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 25/05/2025 11:42:20
 */

public class P8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }

    public static int myAtoi(String s) {
        s = s.trim();

        if (s.isEmpty()) return 0;

        boolean isNegative = false;

        char[] chars = s.toCharArray();
        int i = 0;
        if (chars[0] == '-') {
            isNegative = true;
            i = 1;
        }
        if (chars[0] == '+') {
            i = 1;
        }

        long res = 0;
        while (i < chars.length && chars[i] <= 57 && chars[i] >= 48) {
            res = res * 10 + (chars[i] - 48);
            if (res > Integer.MAX_VALUE){
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            i++;
        }

        return isNegative ? -(int)res : (int)res;
    }
}
