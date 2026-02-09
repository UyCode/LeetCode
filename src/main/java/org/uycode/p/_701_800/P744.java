package org.uycode.p._701_800;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 31/01/2026 10:44:24
 *
 */

public class P744 {

    public static void main(String[] args) {

        char[] letters = {'x','x','y','y'};

        System.out.println(nextGreatestLetter(letters, 'z'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        if (letters[letters.length - 1] < target) return letters[0];
        if (letters[0] > target) return letters[0];

        for (char c: letters) {
            if (c > target) return c;

        }

        return letters[0];
    }
}
