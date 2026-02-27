package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 13/02/2026 13:35:23
 *
 */

public class P1518 {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {

        int ans = numBottles;

        while (numBottles >= numExchange) {
            int a = numBottles / numExchange;
            int b = numBottles % numExchange;
            numBottles = a + b;
            ans += a;
        }
        return ans;
    }
}
