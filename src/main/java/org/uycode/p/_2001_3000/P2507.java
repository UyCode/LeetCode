package org.uycode.p._2001_3000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 05/05/2025 12:51:51
 */

public class P2507 {

    public static void main(String[] args) {
        System.out.println(smallestValue(25));
    }

    public static int smallestValue(int n) {

        int p = primeSum(n);
        while (p < n) {
            n = p;
            p = primeSum(n);
        }

        return p;

    }

    private static int primeSum(int n) {

        int sum = 0;

        for (int i = 2; i <=3 ; i++) {
            while (n % i == 0) {
                sum+=i;
                n /= i;
            }
        }

        for (int i = 5; i <= Math.sqrt(n); i+=6) {
            while (n % i == 0){
                sum += i;
                n /= i;
            }

            while (n % (i+2) == 0) {
                sum += i+2;
                n /= (i+2);
            }
        }

        if (n > 1) {
            sum += n;
        }

        return sum;
    }
}
