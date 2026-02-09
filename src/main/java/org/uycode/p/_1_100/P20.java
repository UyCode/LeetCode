package org.uycode.p._1_100;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 15/05/2025 18:19:40
 */

public class P20 {


    public static void main(String[] args) {
        System.out.println(isValid("{{()[]([])}}"));
    }

    private static final String opens = "{[(";
    private static final String closes = "}])";
    public static boolean isValid(String s) {

        if (s.isEmpty() || s.length() == 1) return false;

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (char c : chars) {
           if (opens.contains(c +"")) {
               stack.push(closes.charAt(opens.indexOf(c)));
           } else {
               if (stack.isEmpty() || stack.peek() != c) return false;
               stack.pop();
           }
        }

        return stack.isEmpty();

    }
}
