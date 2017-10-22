package com.yogi.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Krishan Shukla on 20/10/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.yogi")
@ActiveProfiles("dev")
//@ContextConfiguration(classes = VehicalManagmentApplication.class, initializers = { ConfigFileApplicationContextInitializer.class })
public class VehicalManagmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(VehicalManagmentApplication.class, args);
    }
}
