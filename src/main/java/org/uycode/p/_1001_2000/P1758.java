package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 05/03/2026 16:16:56
 *
 */

public class P1758 {
    public static void main(String[] args) {

        System.out.println(minOperations("0100"));
    }

    public static int minOperations(String s) {

        char[] binaries = s.toCharArray();

        //try 0101 way


        int a = 0;
        int b = 0;
        boolean swap = false;
        for (int i = 0; i < binaries.length; i++) {
            if (swap && binaries[i] == '0') {
                a++;
                swap = false;
                continue;
            }
            swap = true;
        }

        for (int i = 1; i < binaries.length; i+=2) {
            if (binaries[i] == '1') b++;
            else a++;
        }

        return Math.min(a, b);
    }
}
