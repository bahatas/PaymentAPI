#FROM maven:3.6.3-jdk-11-openj9 as builder
#
#WORKDIR /app
#COPY pom.xml .
#RUN mvn clean -Dspring.profiles.active=prod package && rm -r target
#
#COPY src ./src
#RUN mvn clean package -Dmaven.test.skip
## Build a release artifact.
#
#FROM adoptopenjdk/openjdk11
## Copy the jar to the production image from the builder stage.
#COPY --from=builder /app/target/PaymentAPI*.jar /PaymentAPI.jar
#
##ENTRYPOINT ["java","-jar","/app.jar"]
## Run the web service on container startup.
#CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-Dcom.sun.net.ssl.checkRevocation=false","-Dserver.port=8888","-jar","/PaymentAPI.jar"]
#

#FROM openjdk:11-jdk-alpine
FROM maven:3.8.1-jdk-11-openj9 as builder
ARG JAR_FILE=target/*.jar
COPY --from=builder /app/target/PaymentAPI-0.0.1*.jar /PaymentAPI-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar"]