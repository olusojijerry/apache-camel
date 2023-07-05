package com.learnings.apache.route;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyFirstTimerRoute extends RouteBuilder {
    @Autowired
    private GetCurrentTimerBean getCurrentTimerBean;
//    @Autowired
//    private SimpleProcessingBody loggerSimple;
    @Override
    public void configure() throws Exception {
        //timer to trigger
        //transformation
        //database
        //processing
        //transformation
        from("timer:first-timer")//this is the timer that specify the time for trigger
//                .transform().constant("My Constant Message") //you can use the transform method to do whatever you want.
//                .bean("getCurrentTimerBean") //this is one way to call a class
//                .bean(getCurrentTimerBean) // this is another way to call a class especially when it is autowired
                .log("${body}")
                .transform().constant("My message Body")
                .log("${body}")
                .bean(getCurrentTimerBean, "getCurrentTime")//this is another way to call a method in a class this is when you have more than one method in a class
                .log("${body}")
                .process(new SimpleProcess())
//                .bean(loggerSimple) // when having method returning a void it means that the body is not going to change
//                .log("${body}")
                .to("log:first-timer");
    }
}


@Component
class GetCurrentTimerBean{
    public String getCurrentTime(){
        return "Time now is " + LocalDateTime.now();
    }
}

//@Component
class SimpleProcessingBody{
    public void simpleLogger(String message){

    }
}