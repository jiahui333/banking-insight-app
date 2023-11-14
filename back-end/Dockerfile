FROM maven:3.6.3-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim-sid
COPY --from=build /target/banking-insights-app-backend-0.0.1-SNAPSHOT.jar banking-insights-app-backend.jar
ENV DATABASE_PASSWORD=$database-password
ENV SECRET_KEY=$secret-key
RUN echo "spring.datasource.password=${DATABASE_PASSWORD}" >> application.properties
RUN echo "SECRET_KEY=${SECRET_KEY}" >> application.properties
EXPOSE 8080
ENTRYPOINT ["java","-jar","banking-insights-app-backend.jar"]
