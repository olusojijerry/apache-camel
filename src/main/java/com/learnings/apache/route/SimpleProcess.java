package com.learnings.apache.route;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class SimpleProcess implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("Simple Processor testing " + exchange.getMessage().getBody());
//        System.out.println("Simple Processor testing " + exchange.getMessage().getBody());
    }
}
