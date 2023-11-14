# syntax = docker/dockerfile:1.2

FROM maven:3.6.3-jdk-11 AS build
COPY . .
RUN --mount=type=secret,id=database_secret,dst=/etc/secrets/database_secret \
    --mount=type=secret,id=secret_key,dst=/etc/secrets/secret_key \
    bash -c 'DATABASE_SECRET=$(cat /etc/secrets/database_secret) && SECRET_KEY=$(cat /etc/secrets/secret_key) && sed -i "s|\${database_secret}|$DATABASE_SECRET|g" src/main/resources/application.properties && sed -i "s|\${secret_key}|$SECRET_KEY|g" src/main/resources/application.properties && mvn clean package -DskipTests'

FROM openjdk:11-jdk-slim-sid
COPY --from=build /target/banking-insights-app-backend-0.0.1-SNAPSHOT.jar banking-insights-app-backend.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "banking-insights-app-backend.jar"]