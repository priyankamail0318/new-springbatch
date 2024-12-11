package com.fanniemae.amtmaws.new_springbatch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class EventProcessJobReader implements ItemReader<Integer> {

    private final Iterator<Integer> data;

    public EventProcessJobReader() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        this.data = numbers.iterator();
    }

    @Override
    public Integer read() {
        if (data.hasNext()) {
            return data.next();
        } else {
            return null; // Signals end of data
        }
    }
}

