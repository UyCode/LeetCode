package org.uycode.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 14/03/2026 13:03:27
 *
 */

public class CheckPayments {

    public static void main(String[] args) {
        List<String> paymentTypes = new ArrayList<>();
        paymentTypes.add("A");
        paymentTypes.add("B");
        paymentTypes.add("C");
        paymentTypes.add("D");
        paymentTypes.add("E");

        System.out.println(getAvailablePayments(paymentTypes));

    }

    public static List<String> getAvailablePayments(List<String> paymentTypes) {

        List<CompletableFuture<String>> futures = paymentTypes.stream()
                .map(type -> CompletableFuture
                        .supplyAsync(() -> check(type))
                        .exceptionally(e -> null )
                ).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .completeOnTimeout(null, 50, TimeUnit.MILLISECONDS).join();

        return futures.stream()
                .map(f -> f.getNow(null))
                .filter(Objects::nonNull)
                .toList();

    }

    public static String check(String type) {

        try {
            if (type.equals("E") || type.equals("C")) {
                Thread.sleep(100);
            }
            return type;
        } catch (Exception e) {
            return null;
        }
    }
}
