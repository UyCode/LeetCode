package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 11/03/2026 11:11:31
 *
 */

public class P1009 {

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(10));
    }

    public static int bitwiseComplement(int n) {

        if (n == 0) return 1;
        return n ^ (0xFFFFFFFF >>> Integer.numberOfLeadingZeros(n));

    }
}
