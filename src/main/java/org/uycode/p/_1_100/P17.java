package org.uycode.p._1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 02/02/2026 10:21:44
 *
 */

public class P17 {

    public static void main(String[] args) {

    }

    private static final String[] symbols = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {

        int n = digits.length();

        List<String> ans = new ArrayList<>();
        char[] chars = digits.toCharArray();
        for (char c : chars) {
            int num = c - '0';
            
        }

        return null;
    }
}
