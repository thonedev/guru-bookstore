FROM openjdk:21-jdk-slim AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean build

FROM eclipse-temurin:21-jre
WORKDIR /opt/springboot
COPY --from=builder /app/build/libs/*.jar springboot.jar
ARG PROFILE
ARG ADDITIONAL_OPTS
ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}
EXPOSE 8080 5005
ENTRYPOINT ["sh", "-c", "java $ADDITIONAL_OPTS -jar springboot.jar --spring.profiles.active=$PROFILE"]