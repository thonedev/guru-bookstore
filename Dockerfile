FROM openjdk:21-jdk-slim AS builder
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew && ./gradlew clean build -x test

FROM eclipse-temurin:21-jre
WORKDIR /opt/springboot
COPY --from=builder /app/build/libs/*.jar springboot.jar
ARG PROFILE
ARG ADDITIONAL_OPTS
ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

ENV PGHOST=localhost
ENV PGPORT=5432
ENV PGDATABASE=guru_bookstore_db
ENV PGUSER=postgres
ENV PGPASSWORD=My1SecretPass

EXPOSE 8080 5005
ENTRYPOINT ["sh", "-c", "java $ADDITIONAL_OPTS -jar springboot.jar --spring.profiles.active=$PROFILE"]