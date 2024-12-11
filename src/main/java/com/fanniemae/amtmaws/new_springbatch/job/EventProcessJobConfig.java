package com.fanniemae.amtmaws.new_springbatch.job;

import com.fanniemae.amtmaws.new_springbatch.processor.EventProcessJobProcessor;
import com.fanniemae.amtmaws.new_springbatch.reader.EventProcessJobReader;
import com.fanniemae.amtmaws.new_springbatch.writer.EventProcessJobWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class EventProcessJobConfig {

    @Bean
    public Job eventProcessJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("eventProcessJob", jobRepository)
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      EventProcessJobReader reader,
                      EventProcessJobProcessor processor,
                      EventProcessJobWriter writer) {
        return new StepBuilder("step1", jobRepository)
                .<Integer, Integer>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
