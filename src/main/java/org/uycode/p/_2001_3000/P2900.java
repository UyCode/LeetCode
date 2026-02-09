package org.uycode.p._2001_3000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 15/05/2025 00:12:27
 */

public class P2900 {
    public static void main(String[] args) {

        String[] words = {
               "a","b","c","d"
        };

        int[] groups= {1,0,1,1};

        System.out.println(getLongestSubsequence(words, groups));


    }

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {


        List<String> result = new ArrayList<>();
        int n = groups.length;

        for (int i = 0; i < n; i++) {
            result.add(words[i]);
            while (i < n - 1 && groups[i] == groups[i+1]) {
                i++;
            }
        }

        return result;
    }
}
