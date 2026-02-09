package org.uycode.p._701_800;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 23/05/2025 21:47:43
 */

public class P796 {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "abced"));
    }

    public static boolean rotateString(String s, String goal) {

        // or just
        // return s.length() == goal.length && (s+s).contains(goal);

        Set<String> unique = new HashSet<>();

        int n = s.length() - 1;

        while (n >= 0) {
            int len = s.length() - 1;
            s = s.substring(len) + s.substring(0, len);
            unique.add(s);
            n--;
        }
        return unique.contains(goal);
    }
}
