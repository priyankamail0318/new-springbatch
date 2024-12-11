package com.fanniemae.amtmaws.new_springbatch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class EventProcessJobProcessor implements ItemProcessor<Integer, Integer> {

    @Override
    public Integer process(Integer item) {
        return item * 100; // Square the number
    }
}

