package org.uycode.p._1_100;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 31/01/2026 12:12:07
 *
 */

public class P67 {

    public static void main(String[] args) {

        String b = "11";
        String a = "0";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        String longer = a.length() >= b.length() ? a : b;
        String shorter = a.length() >= b.length() ? b : a;

        int n = longer.length();
        int m = shorter.length();

        char[] fixed = new char[n];

        // fill leading zeros
        for (int i = 0; i < n - m; i++) {
            fixed[i] = '0';
        }

        // copy shorter string
        for (int i = 0; i < m; i++) {
            fixed[n - m + i] = shorter.charAt(i);
        }

        char[] origin = longer.toCharArray();


        char[] res = new char[n + 1];
        int carry = 0;
        for (int i = n-1; i >= 0; i--) {
            if (carry == 0) {
                if (origin[i] == '1' && fixed[i] == '1') {
                    carry = 1;
                    res[i+1] = '0';
                } else if (origin[i] == '0' && fixed[i] == '0') {
                  res[i+1] = '0';
                } else {
                    res[i+1] = '1';
                }
            } else {
                if (origin[i] == '1' && fixed[i] == '1') {
                    res[i+1] = '1';
                } else if (origin[i] == '0' && fixed[i] == '0') {
                    res[i+1] = '1';
                    carry = 0;
                } else {
                    res[i+1] = '0';
                }
            }
        }

        if (carry == 1) {
            res[0] = '1';
        }

        StringBuilder ans = new StringBuilder();
        for (char re : res) {
            if (re == '\u0000') continue;
            ans.append(re);
        }

        return ans.toString();
    }
}
