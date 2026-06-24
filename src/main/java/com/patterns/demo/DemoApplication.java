package com.patterns.demo;

import com.patterns.demo.singleton.AppConfig;
import com.patterns.demo.singleton.AppInfoService;
import com.patterns.demo.singleton.DatabaseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner{
	private final DatabaseService databaseService;
	private final AppInfoService appInfoService;
	private final ApplicationContext context;

    public DemoApplication(DatabaseService databaseService, AppInfoService appInfoService, ApplicationContext context) {
        this.databaseService = databaseService;
        this.appInfoService = appInfoService;
        this.context = context;
    }

    public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n=== Singleton Pattern - Spring Version ===\n");
		databaseService.connect();
		System.out.println();
		appInfoService.printBanner();

		System.out.println("\n--- Identity check ---");
		AppConfig ref1 = context.getBean(AppConfig.class);
		AppConfig ref2 = context.getBean(AppConfig.class);
		AppConfig ref3 = context.getBean(AppConfig.class);

		System.out.println("ref1 identity hash: " + System.identityHashCode(ref1));
		System.out.println("ref2 identity hash: " + System.identityHashCode(ref2));
		System.out.println("ref3 identity hash: " + System.identityHashCode(ref3));
		System.out.println("All the same? " + (ref1 == ref2 && ref2 == ref3));
	}
}
