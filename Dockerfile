FROM anapsix/alpine-java:latest

MAINTAINER "Francisco Giana <gianafrancisco@gmail.com>"
WORKDIR /
COPY target/tesis-1.0-SNAPSHOT.jar /tesis-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/tesis-1.0-SNAPSHOT.jar"]
