package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.Single;

@Controller("/")
@ExecuteOn(TaskExecutors.IO)
public class EncryptController {

    private final EncryptionService encryptionService;

    public EncryptController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Get("/encrypt/{text}")
    Single<MyMessage> encrypt(String text) {
        return encryptionService.encrypt(text);
    }
}
