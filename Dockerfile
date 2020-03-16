FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=build/libs/ticket-0.0.1.jar
ADD ${JAR_FILE} ticket-0.0.1.jar
ENTRYPOINT ["java","-jar","/ticket-0.0.1.jar"]