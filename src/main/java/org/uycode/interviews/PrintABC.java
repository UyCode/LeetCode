package org.uycode.interviews;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/03/2026 11:37:21
 *
 */

public class PrintABC {

    static Semaphore semA = new Semaphore(1);
    static Semaphore semB = new Semaphore(0);
    static Semaphore semC = new Semaphore(0);

    public static void main(String[] args) {

        AtomicBoolean isNotDone = new AtomicBoolean(true);
        AtomicInteger counter = new AtomicInteger(0);

        new Thread(() -> {
            Thread.currentThread().setName("Thread-A");
            while (isNotDone.get()) {
                try {
                    if (semA.tryAcquire()) {
                        //semA.acquire();
                        System.out.print("A");
                        semB.release();
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
            Thread.currentThread().interrupt();
        }).start();

        new Thread(() -> {
            Thread.currentThread().setName("Thread-B");
            while (isNotDone.get()) {
                try {
                    if (semB.tryAcquire()) {
                        System.out.print("B");
                        semC.release();
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }

        }).start();


        new Thread(() -> {
            Thread.currentThread().setName("Thread-C");
            while (isNotDone.get()) {
                try {
                    if (semC.tryAcquire()) {
                        System.out.print("C");
                        System.out.println();
                        if (counter.incrementAndGet() < 10) {
                            semA.release();
                        } else {
                            isNotDone.set(false);
                        }

                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }

            }
        }).start();

    }

}

class SemaphoreExample {
    // Initialize a semaphore with 2 permits
    private final Semaphore semaphore = new Semaphore(2);

    public void accessResource(String threadName) {
        try {
            System.out.println(threadName + " is waiting for a permit.");
            semaphore.acquire(); // Acquire a permit
            System.out.println(threadName + " acquired a permit. Accessing resource...");

            try {
                // Simulate work inside the critical section
                Thread.sleep(1000);
            } finally {
                semaphore.release(); // Release the permit in a finally block to ensure it's always called
                System.out.println(threadName + " released a permit.");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();
        for (int i = 1; i <= 5; i++) {
            final String threadName = "Thread-" + i;
            new Thread(() -> example.accessResource(threadName)).start();
        }
    }
}

