package com.example;

import io.micronaut.runtime.server.EmbeddedServer;
import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class EncryptionService {

    private final EmbeddedServer embeddedServer;

    public EncryptionService(EmbeddedServer embeddedServer) {
        this.embeddedServer = embeddedServer;
    }

    Single<MyMessage> encrypt(String text) {
        var encrypted = new StringBuilder(text).reverse().toString();
        return Single.just(new MyMessage(encrypted + " --> port: " + embeddedServer.getPort()));
    }
}
