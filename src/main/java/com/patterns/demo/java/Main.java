package com.patterns.demo.java;

/**
 * Entry point. Run this to see the Singleton in action.
 *
 * Things to observe in the output:
 *  - "[AppConfig] Loading configuration..." prints exactly ONCE
 *    even though three different places call getInstance()
 *  - The identity hash codes of all three references are identical
 *    which proves they point to the same object in memory
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Singleton Pattern - Plain Java ===\n");

        // --- Two services, each independently grabbing the config ---
        DatabaseService dbService  = new DatabaseService();
        AppInfoService  appService = new AppInfoService();

        dbService.connect();
        System.out.println();
        appService.printBanner();

        // --- Prove it's the same object in memory ---
        System.out.println("\n--- Identity check ---");
        AppConfig ref1 = AppConfig.getInstance();
        AppConfig ref2 = AppConfig.getInstance();
        AppConfig ref3 = AppConfig.getInstance();

        System.out.println("ref1 identity hash: " + System.identityHashCode(ref1));
        System.out.println("ref2 identity hash: " + System.identityHashCode(ref2));
        System.out.println("ref3 identity hash: " + System.identityHashCode(ref3));
        System.out.println("All the same? " + (ref1 == ref2 && ref2 == ref3));
    }
}
