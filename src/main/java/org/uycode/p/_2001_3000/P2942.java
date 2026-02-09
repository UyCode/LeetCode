package org.uycode.p._2001_3000;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 24/05/2025 10:56:01
 */

public class P2942 {

    public static void main(String[] args) {
        System.out.println(findWordsContaining(new String[]{"abc", "dd", "bcvcda", "dffffdd"}, 'a'));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            char[] temp = words[i].toCharArray();
            for (char c : temp) {
                if (c == x) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }
}
