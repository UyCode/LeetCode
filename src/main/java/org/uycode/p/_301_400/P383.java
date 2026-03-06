package org.uycode.p._301_400;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/03/2026 17:22:52
 *
 */

public class P383 {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) return false;

        int[] cnt = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            cnt[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) return false;
        }

        return true;

    }
}
