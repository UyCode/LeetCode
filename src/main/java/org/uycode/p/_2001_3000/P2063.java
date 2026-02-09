package org.uycode.p._2001_3000;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 04/05/2025 23:51:35
 */

public class P2063 {

    public static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(100_000);
        for (int i = 0; i < 100_000; i++) {
            // Generate a random lowercase letter (a-z)
            char randomChar = (char) ('a' + ThreadLocalRandom.current().nextInt(26));
            sb.append(randomChar);
        }
        System.out.println(sb.toString());

        P2063 p2063 = new P2063();

        System.out.println(p2063.countVowels(sb.toString()));

    }

    public long countVowels(String world) {

        int n = world.length();
        //char[] chars = world.toCharArray();
        long ans = 0;
        for (int i =0; i < n; i++) {
            if (vowels.contains(world.charAt(i))) {
                ans += (long) (i + 1) * (n - i);
            }
        }

        return ans;
    }
}
