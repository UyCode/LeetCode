package org.uycode.p._1001_2000;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 08/02/2026 12:19:42
 *
 */

public class P1925 {

    public static void main(String[] args) {
        System.out.println(countTriples(5));
    }

    public static int countTriples(int n) {

        int ans = 0;

        for (int i = 3; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                double t = customSqrt(i * i + j * j);
                if (t <= n && t == (long) t) {
                    ans += 2;
                }
            }
        }

        return ans;
    }

    public static double customSqrt(double n) {
        // Handle edge cases
        if (n < 0) return Double.NaN;
        if (n == 0) return 0;

        // Start with an initial guess (n/2 is a common starting point)
        double guess = n / 2.0;

        // Define how much precision we want (epsilon)
        double epsilon = 10e-7;

        double nextGuess = 0.5 * (guess + n / guess);

        // Keep refining the guess until the change is smaller than epsilon
        while (Math.abs(guess - nextGuess) > epsilon) {
            guess = nextGuess;
            nextGuess = 0.5 * (guess + n / guess);
        }

        return nextGuess;
    }
}
