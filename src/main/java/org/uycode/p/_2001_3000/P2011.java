package org.uycode.p._2001_3000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 13/02/2026 12:16:24
 *
 */

public class P2011 {

    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"++X","++X","X++"}));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int n  = 0;

        for (String s : operations) {
            if (s.charAt(0) == '+' || s.charAt(1) == '+') {
                n++;
            } else {
                n--;
            }
        }
        return n;
    }
}
