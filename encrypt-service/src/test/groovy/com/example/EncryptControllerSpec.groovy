package com.example

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class EncryptControllerSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)

    EncryptClient encryptClient = embeddedServer.applicationContext.getBean(EncryptClient)

    void 'test encrypt controller'() {
        expect:
        encryptClient.encrypt("Hola JavaMexico").text == 'ocixeMavaJ aloH'
    }

    void 'test encrypt controller 2'() {
        expect:
        encryptClient.encrypt("Hola JavaMexico").text == 'ocixeMavaJ aloH'
    }
}
