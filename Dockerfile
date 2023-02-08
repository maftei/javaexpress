FROM openjdk:11
ADD target/javaexpressclone-0.0.7-SNAPSHOT.jar javaexpressclone-0.0.7-SNAPSHOT.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "javaexpressclone-0.0.7-SNAPSHOT.jar"]
RUN wget https://static.snyk.io/cli/latest/snyk-linux && \
    chmod +x snyk-linux && \
    mv snyk-linux /usr/local/bin/snyk-linux



