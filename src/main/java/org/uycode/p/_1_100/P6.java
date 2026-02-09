package org.uycode.p._1_100;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 24/05/2025 11:08:02
 */

public class P6 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRow) {

        if (numRow == 1) return s;

        int n = 2 * numRow -2;

        StringBuilder sb = new StringBuilder();

        int i =0;
        while (numRow > 0) {

            for (int j = i; j *n < s.length(); j++) {
                sb.append(s.charAt(j * n));
            }
            i++;
            numRow--;
        }




        return sb.toString();
    }
}
