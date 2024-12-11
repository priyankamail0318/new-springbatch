package com.fanniemae.amtmaws.new_springbatch.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventProcessJobWriter implements ItemWriter<Integer> {

    @Override
    public void write(Chunk<? extends Integer> chunk) throws Exception {
        System.out.println("Processed Data: " + chunk);
    }
}

