package com.fanniemae.amtmaws.new_springbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NewSpringbatchApplication {

    private static final Logger log = LoggerFactory.getLogger(NewSpringbatchApplication.class);

    public static void main(String[] args) {
        log.info("Spring Batch Application is Running.");
        SpringApplication.run(NewSpringbatchApplication.class, args);
    }

}
