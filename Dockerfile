FROM openjdk:17-jdk-alpine
COPY build/libs/project-api.jar project-api.jar
ENTRYPOINT ["java", "-jar", "project-api.jar"]