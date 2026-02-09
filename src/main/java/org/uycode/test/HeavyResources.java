package org.uycode.test;

/**
 * @author <a href="mailto:binezir@outlook.com">Ahmatjan</a>
 * @apiNote <>
 * @since 09/02/2026 17:04:14
 *
 */

public class HeavyResources {

    private HeavyResources() {
        System.out.println("loading heavy resources...");
    }

    private static class Holder {
        private static final HeavyResources INSTANCE = new HeavyResources();
    }

    public static HeavyResources getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        HeavyResources instance = getInstance();
    }
}
