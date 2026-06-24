package com.patterns.demo.java;

/**
 * Simulates an unrelated service that also needs config.
 * It has no idea DatabaseService exists — yet both get the same AppConfig.
 */
public class AppInfoService {

    public void printBanner() {
        AppConfig config = AppConfig.getInstance();  // gets the SAME instance
        System.out.println("[AppInfoService] App : " + config.get("app.name"));
        System.out.println("[AppInfoService] Ver : " + config.get("app.version"));
    }
}
