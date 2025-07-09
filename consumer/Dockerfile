# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21.0.6_7-jre
WORKDIR /app

# Use a non-root user
RUN groupadd --system appgroup && useradd --system --no-create-home --gid appgroup appuser && \
    chown -R appuser:appgroup /app

USER appuser

COPY --from=build /app/target/consumer-app.jar ./consumer-app.jar

EXPOSE 8081
CMD ["java", "-jar", "consumer-app.jar"]
