FROM openjdk:14-alpine
COPY build/libs/gateway-*-all.jar gateway.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "gateway.jar"]