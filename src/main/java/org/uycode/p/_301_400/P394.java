package org.uycode.p._301_400;

import java.util.*;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 15/05/2025 19:20:54
 */

public class P394 {

    public static void main(String[] args) {
        System.out.println(decodeString("ab3[c2[f4[d]]]3[xyz]"));
    }

    public static String decodeString(String s) {

        Stack<Integer> numbers = new Stack<>();
        Stack<String> stack = new Stack<>();

        StringBuilder res = new StringBuilder();

        int num = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (Character.isLetter(c)) {
                res.append(c);
            } else if (c == '[') {
                numbers.push(num);
                num = 0;
                //if (res.isEmpty()) continue;
                stack.push(res.toString());
                res = new StringBuilder();
            } else {
                int times = numbers.pop();
                for (int j = 0; j < times; j++) {
                    stack.push(stack.pop() + res);
                }
                res = new StringBuilder(stack.pop());
            }
        }


        return res.toString();
    }
}
