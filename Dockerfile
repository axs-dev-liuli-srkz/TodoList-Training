FROM openjdk:11-jdk-slim

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
# FROM openjdk:8-jdk-alpine
# VOLUME /tmp
# ARG JAR_FILE
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]