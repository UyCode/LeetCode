package org.uycode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 30/04/2025 19:22:50
 */

public class P139 {

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pen");
        System.out.println(workBreak(s, dict));
    }


    public static boolean workBreak(String s, List<String> wordDict) {

        Set<String> wordDicts = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDicts.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
