package com.patterns.demo.singleton.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Classic Singleton implementation.
 *
 * Rules of the pattern:
 *  1. Private constructor   — nobody can do "new AppConfig()" from outside
 *  2. Private static field  — the one and only instance lives here
 *  3. Public static method  — the only door in
 *
 * This version uses the "double-checked locking" approach, which is
 * thread-safe without locking on every single call.
 */
public class AppConfig {

    // Step 2: hold the single instance
    // volatile ensures visibility across threads
    private static volatile AppConfig instance;

    // Simulates settings loaded from a file / environment
    private final Map<String, String> settings;

    // Step 1: private constructor - nobody outside can call new AppConfig()
    private AppConfig() {
        System.out.println("[AppConfig] Loading configuration... (this should print only ONCE)");
        settings = new HashMap<>();
        settings.put("db.url",      "jdbc:postgresql://localhost:5432/mydb");
        settings.put("db.username", "admin");
        settings.put("app.name",    "Singleton Practice App");
        settings.put("app.version", "1.0.0");
    }

    // Step 3: the one public door in
    public static AppConfig getInstance() {
        if (instance == null) {                    // first check (no lock)
            synchronized (AppConfig.class) {
                if (instance == null) {            // second check (with lock)
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public String get(String key) {
        return settings.getOrDefault(key, "NOT_FOUND");
    }
}
