package com.patterns.demo.singleton;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    private final AppConfig config;

    public DatabaseService(AppConfig config) {
        this.config = config;
    }
    public void connect() {
        System.out.println("[DatabaseService] Connecting to: " + config.get("db.url"));
        System.out.println("[DatabaseService] As user:       " + config.get("db.username"));
    }
}
