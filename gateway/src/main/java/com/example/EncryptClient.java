package com.example;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Recoverable;
import io.reactivex.Single;

@Client(id = "encrypt-service")
@Recoverable(api = EncryptOperations.class)
public interface EncryptClient extends EncryptOperations {

    @Override
    @Get("/encrypt/{text}")
    Single<MyMessage> encrypt(String text);
}
