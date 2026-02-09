package org.uycode.test;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 06/05/2025 16:33:18
 */

public class MyConcrete extends MyBbs{


    public MyConcrete(int a, int b) {
        super(a, b);
    }

    @Override
    public void say() {
        System.out.println("say from extend class");
    }

    @Override
    public void print() {
        System.out.println("a is: " +a);
        System.out.println("b is: " +b);
    }

    public static void main(String[] args) {
        MyBbs a = new MyConcrete(2, 3);
        a.print();
        a.say();
    }
}
