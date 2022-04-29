FROM maven:3.8-openjdk-11

MAINTAINER SECRETARIA DE PROTEÇÃO SOCIAL
ENV TZ=America/Fortaleza

COPY . /app
WORKDIR /app

RUN mvn clean install -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/target/oisol-api.jar"]
