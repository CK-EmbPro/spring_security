FROM openjdk:21-jdk AS build
WORKDIR /springsec
COPY ./.mvn ./.mvn
COPY ./mvnw ./mvnw
RUN chmod +x mvnw
COPY pom.xml .
COPY src ./src
RUN ./mvnw clean package -DskipTests


FROM openjdk:21-jdk-slim
WORKDIR /springsec
RUN apt-get update && apt-get install -y iputils-ping && apt-get clean
RUN apt-get update && apt-get install -y net-tools && apt-get clean
COPY --from=build /springsec/target/*.jar springsec.jar
ENTRYPOINT ["java","-jar","springsec.jar"]