FROM openjdk:21-jdk-slim

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/springboot

COPY build/libs/*.jar springboot.jar

EXPOSE 8080 5005

ENTRYPOINT ["sh", "-c", "java $ADDITIONAL_OPTS -jar springboot.jar --spring.profiles.active=$PROFILE"]