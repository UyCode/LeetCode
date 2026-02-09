package org.uycode.p._801_900;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 02/05/2025 12:48:15
 */

public class P838 {


    public static void main(String[] args) {
        System.out.println(pushDominoes("LR.LL"));
    }

    public static String pushDominoes(String dominoes) {

        dominoes = "L" + dominoes + "R";

        char[] dom = dominoes.toCharArray();

        int l = 0;
        StringBuilder res = new StringBuilder();

        for (int r = 1; r < dominoes.length(); r++) {
            if (dom[r] == '.') continue;
            if (l != 0) res.append(dom[l]);

            int mid = r - l - 1;
            if (dom[l] == dom[r]) {
                res.append(String.valueOf(dom[l]).repeat(Math.max(0, mid)));
            } else if (dom[l] == 'L' && dom[r] == 'R') {
                res.append(".".repeat(Math.max(0, mid)));
            } else {
                res.append("R".repeat(Math.max(0, mid / 2)));
                if (mid % 2 == 1) res.append('.');
                res.append("L".repeat(Math.max(0, mid / 2)));
            }
            l = r;
        }

        return res.toString();
    }
}
