package com.patterns.demo.singleton;

import org.springframework.stereotype.Service;

@Service
public class AppInfoService {
    private final AppConfig config;

    public AppInfoService(AppConfig config) {
        this.config = config;
    }
    public void printBanner() {
        System.out.println("[AppInfoService] App : " + config.get("app.name"));
        System.out.println("[AppInfoService] Ver : " + config.get("app.version"));
    }
}
