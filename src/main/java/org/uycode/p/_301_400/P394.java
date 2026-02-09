package org.uycode.p._301_400;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 15/05/2025 19:20:54
 */

public class P394 {

    public static void main(String[] args) {
        System.out.println(decodeString("abc3[cd]xyz"));
    }

    public static String decodeString(String s) {


        Map<Integer, String> map = new HashMap<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder num = new StringBuilder();
                num.append(s.charAt(i));
                i++;
                while (Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i));
                    i++;
                }
                if (s.charAt(i) == '[') {
                    i++;
                    int index = s.indexOf(']', i);
                    String sub = s.substring(i, index);
                    int number = Integer.parseInt(num.toString());
                    while (number > 0) {
                        result.append(sub);
                        number--;
                    }
                    i = index;
                }
            } else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();

    }
}
