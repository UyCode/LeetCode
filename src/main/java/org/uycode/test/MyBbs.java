package org.uycode.test;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/05/2025 16:31:15
 */

abstract class MyBbs {

    int a;
    int b;

    public MyBbs(int a, int b) {
        this.a=a;
        this.b=b;
    }

    public void print() {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public void say() {
        System.out.println("hello world");
    }

}
