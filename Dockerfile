FROM openjdk:11
ADD target/javaexpressclone-0.0.6-SNAPSHOT.jar javaexpressclone-0.0.6-SNAPSHOT.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "javaexpressclone-0.0.6-SNAPSHOT.jar"]
RUN wget https://static.snyc.io/cli/latest/snyc-linux && \
    chmod +x snyk-linux && \
    mv snyk-linux /usr/local/bin/snyk-linux



