FROM openjdk:11
ADD target/javaexpressclone-0.0.1-SNAPSHOT.jar javaexpressclone-0.0.1-SNAPSHOT.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "javaexpressclone-0.0.1-SNAPSHOT.jar"]



