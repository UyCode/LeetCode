package org.uycode.contest._177;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 01/03/2026 10:32:19
 *
 */

public class Q11 {

    public static void main(String[] args) {
        String a = "aeiou";
        System.out.println(trimTrailingVowels(a));
    }

    private static final Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
    public static String trimTrailingVowels(String s) {

        int idx = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (set.contains(chars[i])) {
                idx++;
                continue;
            }
            break;
        }

        return s.substring(0, s.length() - idx);

    }
}
