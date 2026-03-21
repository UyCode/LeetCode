package org.uycode.p._401_500;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/03/2026 19:00:30
 *
 */

public class P405 {

    public static void main(String[] args) {
        System.out.println(toHex(-1));
        System.out.println(Integer.toHexString(-1));
        System.out.println(Integer.toHexString(Integer.MAX_VALUE-3));
    }

    public static final String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String toHex(int num) {

        if (num == 0) return "0";

        String ans;
        if (num < 0) {
            long unsignedLong = num & 0xFFFFFFFFL;
            ans = getHex(unsignedLong);
        } else {
            ans = getHex(num);
        }

        return ans;
    }

    private static String getHex(long n) {
        long rem = n % 16;
        if (n - rem == 0) {
            return hex[(int)rem];
        }

        return getHex((n - rem) / 16) + hex[(int)rem];
    }

}
