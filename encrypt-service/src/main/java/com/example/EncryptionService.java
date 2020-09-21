package com.example;

import io.micronaut.runtime.server.EmbeddedServer;
import io.reactivex.Single;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class EncryptionService {

    private final EmbeddedServer embeddedServer;
    private final AuditRepository auditRepository;

    public EncryptionService(EmbeddedServer embeddedServer,
                             AuditRepository auditRepository) {
        this.embeddedServer = embeddedServer;
        this.auditRepository = auditRepository;
    }

    @Transactional
    Single<MyMessage> encrypt(String text) {
        auditRepository.save(new Audit(encrypted));

        var encrypted = new StringBuilder(text).reverse().toString();
        return Single.just(new MyMessage(encrypted + " --> port: " + embeddedServer.getPort()));
    }
}
