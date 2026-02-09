package org.uycode.p._901_1000;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 23/05/2025 22:08:37
 */

public class P946 {

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num); // num 入栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

}
