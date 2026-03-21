package org.uycode.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/03/2026 11:22:14
 *
 */

public class RaceDemo {

    public static void main(String[] args) throws Exception{

        int n = 10;

        CountDownLatch startSignal = new CountDownLatch(1);

        CountDownLatch finish = new CountDownLatch(n);

        AtomicBoolean hasError = new AtomicBoolean(false);

        ExecutorService pool = Executors.newFixedThreadPool(n);

        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final int id = i;

            futures.add(pool.submit(() -> {
                try {
                    startSignal.await();
                    if (hasError.get()) return ;
                    System.out.println("运动员 " + id + " 开跑");
                    Thread.sleep(new Random().nextInt(1000));
                    //if (id == 5) throw new Exception();
                    System.out.println("运动员" + id + " 到达了终点");
                } catch (Exception e) {
                    System.out.println("运动员 " + id + "发生意外");
                    hasError.set(true);
                    futures.forEach(f -> f.cancel(true));
                } finally {
                    finish.countDown();
                }
            }));
        }

        System.out.println("预备.....\n开始！");

        startSignal.countDown();
        finish.await();
        if (hasError.get()) {
            System.out.println("跑步过程发生意外，比赛终止...");
        } else {
            System.out.println("所有运动员到达了终点");
        }
        pool.shutdown();


    }
}
