FROM maven:3.6.3-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim-sid
COPY --from=build /target/banking-insights-app-backend-0.0.1-SNAPSHOT.jar banking-insights-app-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","banking-insights-app-backend.jar"]
