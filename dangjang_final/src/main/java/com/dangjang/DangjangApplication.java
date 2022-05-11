package com.dangjang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc
@ComponentScan(basePackages = {"com.dangjang.*"})
@EnableJpaAuditing
@SpringBootApplication
public class DangjangApplication {

    public static void main(String[] args) {
        SpringApplication.run(DangjangApplication.class, args);
    }


}
