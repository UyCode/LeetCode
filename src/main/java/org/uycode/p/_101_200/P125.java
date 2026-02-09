package org.uycode.p._101_200;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/05/2025 19:42:51
 */

public class P125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase(Locale.ROOT);
        s = s.replaceAll("[^a-z0-9]", "");
        StringBuilder rev = new StringBuilder(s).reverse();
        return rev.toString().contentEquals(s);


    }
}
