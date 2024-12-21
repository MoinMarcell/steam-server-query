FROM --platform=linux/amd64 openjdk:21
EXPOSE 8080
COPY target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
