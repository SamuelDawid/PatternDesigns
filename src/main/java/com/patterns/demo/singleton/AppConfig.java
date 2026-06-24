package com.patterns.demo.singleton;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppConfig {
    Map<String, String> settings;

    @PostConstruct
    public void loadConfig(){
        System.out.println("[AppConfig] Loading configuration... (this should print only ONCE)");
        settings = new HashMap<>();
        settings.put("db.url",      "jdbc:postgresql://localhost:5432/mydb");
        settings.put("db.username", "admin");
        settings.put("app.name",    "Singleton Practice App");
        settings.put("app.version", "1.0.0");
    }

    public String get(String key) {
        return settings.getOrDefault(key, "NOT_FOUND");
    }
}
