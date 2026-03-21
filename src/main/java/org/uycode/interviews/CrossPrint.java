package org.uycode.interviews;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/03/2026 12:16:02
 *
 */

public class CrossPrint {



    public static void main(String[] args) {

        Object lock = new Object();

        AtomicInteger num = new AtomicInteger(1);

        Thread odd = new Thread(() -> {
            while (num.get() <= 100) {
                synchronized (lock) {
                    if (num.get() % 2 == 1) {
                        System.out.println("Odd Thread: " + num.getAndIncrement());
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (Exception e) {}
                    }
                }
            }
        });


        Thread even = new Thread(() -> {
            while (num.get() <= 100) {
                synchronized (lock) {
                    if (num.get() % 2 == 0) {
                        System.out.println("Evn Thread: " + num.getAndIncrement());
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (Exception e) {}
                    }
                }
            }
        });

        odd.start();
        even.start();

    }
}
