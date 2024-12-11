package com.fanniemae.amtmaws.new_springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NewSpringbatchApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(NewSpringbatchApplication.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job eventProcessJob;

    public static void main(String[] args) {
        log.info("Spring Batch Application is Running Today ...");
        SpringApplication.run(NewSpringbatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Spring Batch Application is Running.");
        Job jobToRun = eventProcessJob;
        jobLauncher.run(jobToRun, new JobParameters());

    }

}
