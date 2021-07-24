package com.sobyanin.kart;

import com.sobyanin.kart.config.RootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = RootConfiguration.class)
public class KartApplication {

    public static void main(String[] args) {
        SpringApplication.run(KartApplication.class, args);
    }

}
