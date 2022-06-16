FROM eclipse-temurin:11.0.14_9-jre-alpine as builder
WORKDIR application
COPY target/diabete-0.0.1-SNAPSHOT.jar  mediscreendiabete-1.0.0.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mediscreendiabete-1.0.0.jar"]
