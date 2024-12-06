package com.antilob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Configuration
@EnableJpaRepositories(basePackages = "com.antilob.engine.database.repository")
@ComponentScan (basePackages = {"com.antilob.engine.controller","com.antilob.engine.database","com.antilob.engine.service"})
@EntityScan (basePackages = {"com.antilob.engine.database.entity"})
public class AppConfig {
    @Autowired
    private Environment env;
    public AppConfig() {
//        System.out.println("AppConfig constructor...");
        //System.out.println("datasourse "+env.getProperty("spring.datasource.url"));
    }

}
