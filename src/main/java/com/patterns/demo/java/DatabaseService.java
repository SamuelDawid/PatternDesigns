package com.patterns.demo.java;

/**
 * Simulates a service that needs database config.
 * It calls AppConfig.getInstance() on its own — it doesn't know
 * whether an instance already exists. That's the point.
 */
public class DatabaseService {

    public void connect() {
        AppConfig config = AppConfig.getInstance();  // gets the SAME instance
        System.out.println("[DatabaseService] Connecting to: " + config.get("db.url"));
        System.out.println("[DatabaseService] As user:       " + config.get("db.username"));
    }
}
