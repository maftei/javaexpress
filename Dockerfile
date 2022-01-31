FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} javaexpressclone-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/javaexpressclone-0.0.1-SNAPSHOT.jar"]
