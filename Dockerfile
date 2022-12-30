FROM openjdk:17-jdk-slim
WORKDIR /vote-service

COPY votos-microservice-0.0.1-SNAPSHOT.jar /vote-service/app.jar
ENTRYPOINT ["java","-jar","app.jar"]