package org.uycode.p._1_100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 02/02/2026 10:05:38
 *
 */

public class P12 {

    private static final String[] THOUSANDS = {"", "M", "MM", "MMM"};
    private static final String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ONES = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }

    public static String intToRoman(int num) {

        return THOUSANDS[num / 1000] + HUNDREDS[num%1000/100] + TENS[num%100/10] + ONES[num%10];
    }
}
