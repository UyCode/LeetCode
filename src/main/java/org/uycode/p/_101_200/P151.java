package org.uycode.p._101_200;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 23/05/2025 15:34:00
 */

public class P151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("   hello world  "));
    }

    public static String reverseWords(String s) {

        s = s.replaceAll("\\s+", ",");
        if (s.charAt(0) == ',') s = s.substring(1);
        if (s.charAt(s.length()-1) == ',') s = s.substring(0, s.length()-1);
        String[] split = s.split(",");
        StringBuilder sb = new StringBuilder();

        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }
}
