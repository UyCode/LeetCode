package org.uycode.test;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 21/01/2026 21:23:52
 *
 */

public class StringExample {

    public static void main(String[] args) {
        String a = "hello world";
        String b = a.intern();

        if (a.equals(b)) {
            System.out.println("yes");
        }
    }
}
