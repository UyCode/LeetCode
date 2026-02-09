package org.uycode.p._401_500;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 23/05/2025 21:18:15
 */

public class P415 {

    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
    }

    public static String addStrings(String num1, String num2) {

        if (num2.length() > num1.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        StringBuilder res = new StringBuilder();
        int n = num1.length();
        int m = num2.length();
        int carry = 0;
        while (n > 0 && m > 0) {
            int a = n1[n - 1] - 48;
            int b = n2[m - 1] - 48;
            int c = a + b + carry;
            if (c > 9) {
                res.append(c%10);
                carry = 1;
            } else {
                res.append(c);
                carry = 0;
            }
            m--;
            n--;
        }

        while (n > 0) {
            int a = n1[n - 1] - 48;
            int b = a + carry;
            if (b > 9) {
                res.append(b % 10);
                carry = 1;
            } else {
                res.append(b);
                carry = 0;
            }
            n--;
        }

        if (carry == 1) res.append(carry);


        return res.reverse().toString();
    }
}
