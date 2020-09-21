package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@Controller("/")
@ExecuteOn(TaskExecutors.IO)
public class EncryptController {

    @Get("/encrypt/{text}")
    MyMessage encrypt(String text) {
        System.out.println(Thread.currentThread().getName());
        String encrypted = new StringBuilder(text).reverse().toString();
        return new MyMessage(encrypted);
    }

}
