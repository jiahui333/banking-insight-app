# # syntax = docker/dockerfile:1.2

# FROM maven:3.6.3-jdk-11 AS build
# COPY . .
# RUN mvn clean package -DskipTests

# FROM openjdk:11-jdk-slim-sid
# COPY --from=build /target/banking-insights-app-backend-0.0.1-SNAPSHOT.jar banking-insights-app-backend.jar
# RUN --mount=type=secret,id=database_password,dst=/etc/secrets/database_password \
#     && echo "spring.datasource.password=$(cat /etc/secrets/database_password)" >> src/main/resources/application.properties
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","banking-insights-app-backend.jar"]


# syntax = docker/dockerfile:1.2


FROM maven:3.6.3-jdk-11 AS build
WORKDIR /app
COPY . .
RUN --mount=type=secret,id=database_secret,dst=/etc/secrets/database_secret \
    && SECRET=$(cat /etc/secrets/database_secret) \
    && sed -i "s|\${database_secret}|$SECRET|" src/main/resources/application.properties \
    && mvn clean package -DskipTests

FROM openjdk:11-jdk-slim-sid
WORKDIR /app
COPY --from=build /app/target/banking-insights-app-backend-0.0.1-SNAPSHOT.jar banking-insights-app-backend.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "banking-insights-app-backend.jar", "--spring.config.location=classpath:/application.properties"]
