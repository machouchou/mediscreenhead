FROM eclipse-temurin:11.0.14_9-jre-alpine as builder
WORKDIR application
COPY target/mediscreennote-0.0.1-SNAPSHOT.jar  mediscreennote-1.0.0.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "mediscreennote-1.0.0.jar"]
