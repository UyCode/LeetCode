package org.uycode.p._1001_2000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 05/05/2025 23:47:56
 */

public class P1713 {

    public static void main(String[] args) {
        String[] dict = {
                "looked",
                "just",
                "like",
                "her",
                "brother"
        };
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(respace(dict, sentence));
    }

    public static int respace(String[] dictionary, String sentence) {

        Arrays.sort(dictionary, Comparator.comparingInt(String::length).reversed());

        StringBuilder sb = new StringBuilder(sentence);
        for (String sub: dictionary) {
            int index = sb.indexOf(sub);
            while (index != -1) {
                sb.replace(index, index + sub.length(), "");
                index = sb.indexOf(sub);
            }
        }

        return sb.length();
    }
}
