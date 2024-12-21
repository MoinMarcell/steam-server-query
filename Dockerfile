# Build-Stage
FROM --platform=linux/amd64 maven:3.9.4 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B package

# Runtime-Stage
FROM --platform=linux/amd64 openjdk:21
EXPOSE 8080
WORKDIR /app
COPY --from=builder /app/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
