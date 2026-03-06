package org.uycode.p._301_400;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/03/2026 16:43:50
 *
 */

public class P374 {

    private static final int pick = 1702766719;

    public static void main(String[] args) {
        System.out.println(guessNumber(2126753390));
    }

    public static int guessNumber(int n) {
        int f = guess(n);
        long r = n;
        long l = 1;
        long ans = n;
        while (f != 0) {
            ans = (r + l) / 2;
            f = guess((int)ans);
            if (f == -1) {
                r = ans;
            }
            if (f == 1){
                l = ans;
            }
        }

        return (int)ans;
    }

    private static int guess(int n) {
        return Integer.compare(pick, n);

    }
}
