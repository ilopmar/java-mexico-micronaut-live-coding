package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.tracing.annotation.NewSpan;
import io.micronaut.tracing.annotation.SpanTag;

import io.reactivex.Single;

@Controller("/api/${api.version:v1}")
@ExecuteOn(TaskExecutors.IO)
public class ApiController implements EncryptOperations {

    private final EncryptClient encryptClient;

    public ApiController(EncryptClient encryptClient) {
        this.encryptClient = encryptClient;
    }

    @NewSpan
    @Get("/encrypt/{text}")
    public Single<MyMessage> encrypt(@SpanTag("plain-text") String text) {
        return encryptClient.encrypt(text);
    }
}
