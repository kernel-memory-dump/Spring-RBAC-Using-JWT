package co.decem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.util.Assert;


record GreetingRequest(String name){}

record GreetingResponse(String message){}


@Controller
class GreetingControllerAdvice {

    @MessageExceptionHandler
    @SendTo("/topic/errors")
    public String handleException(IllegalArgumentException e) {
        var message = ("an exception occurred! " + NestedExceptionUtils.getMostSpecificCause(e));
        System.out.println(message);
        return message;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/greetings")
    GreetingResponse greet(GreetingRequest request) throws Exception {
        Assert.isTrue(Character.isUpperCase(request.name().charAt(0)), () -> "the name must start with a capital letter!");
        Thread.sleep(1_000);
        return new GreetingResponse("Hello, " + request.name());
    }


}
