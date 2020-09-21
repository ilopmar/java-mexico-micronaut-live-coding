FROM openjdk:14-alpine
COPY build/libs/encrypt-service-*-all.jar encrypt-service.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "encrypt-service.jar"]