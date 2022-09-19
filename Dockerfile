FROM openjdk:alpine AS builder
ADD target/javaexpressclone-0.0.5-SNAPSHOT.jar javaexpressclone-0.0.5-SNAPSHOT.jar
EXPOSE 80
FROM alpine
ENTRYPOINT ["java", "-jar", "javaexpressclone-0.0.5-SNAPSHOT.jar"]



