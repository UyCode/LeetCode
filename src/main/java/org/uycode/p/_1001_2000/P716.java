package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 10/02/2026 12:52:38
 *
 */

public class P716 {

    public static void main(String[] args) {
        System.out.println(totalMoney(10));
    }

    public static int totalMoney(int n) {

        int a = n / 7;
        int c = a+1;
        int rem = n % 7;

        int ans = 0;
        int start = 28;

        while (a > 0) {
            ans += start;
            start += 7;
            a--;
        }

        while (rem > 0) {
            ans += c;
            c++;
            rem--;
        }


        return ans;

    }
}
