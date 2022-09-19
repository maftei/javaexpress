FROM openjdk:alpine AS builder
ADD target/javaexpressclone-0.0.5-SNAPSHOT.jar javaexpressclone-0.0.5-SNAPSHOT.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "javaexpressclone-0.0.5-SNAPSHOT.jar"]
FROM alpine
ADD target/javaexpressclone-0.0.5-SNAPSHOT.jar javaexpressclone-0.0.5-SNAPSHOT.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "javaexpressclone-0.0.5-SNAPSHOT.jar"]



