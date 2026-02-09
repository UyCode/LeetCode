package org.uycode.p._101_200;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 01/02/2026 13:13:02
 *
 */

public class P191 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(2147483645));
    }

    public static int hammingWeight(int n) {
        String bs = Integer.toBinaryString(n);
        int sum = 0;
        for(char c: bs.toCharArray()) {
            sum += c - '0';
        }

        return sum;
    }
}
