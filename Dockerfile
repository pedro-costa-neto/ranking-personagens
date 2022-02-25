FROM openjdk:17-jdk-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/spring-app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar","/app/spring-app.jar"]