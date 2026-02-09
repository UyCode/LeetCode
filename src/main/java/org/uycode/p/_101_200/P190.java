package org.uycode.p._101_200;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 01/02/2026 12:48:02
 *
 */

public class P190 {

    public static void main(String[] args) {
        reverseBits(43261596);
    }

    public static int reverseBits(int n) {

        int res = reverse(n);
        System.out.println(res);

        return res;
    }

    private static int reverse(int i) {
        // HD, Figure 7-1
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;

        return reverseBytes(i);
    }

    private static int reverseBytes(int i) {
        return (i << 24)            |
                ((i & 0xff00) << 8)  |
                ((i >>> 8) & 0xff00) |
                (i >>> 24);
    }
}
