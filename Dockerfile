FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .

RUN chmod +x mvnw && ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21-jre-alpine

RUN addgroup -S quarkus && adduser -S quarkus -G quarkus

WORKDIR /deployments

COPY --chown=quarkus:quarkus --from=builder /app/target/quarkus-app/ .

USER quarkus

EXPOSE 8080

ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0"

ENTRYPOINT ["java", "-jar", "quarkus-run.jar"]