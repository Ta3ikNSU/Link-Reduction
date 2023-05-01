FROM openjdk:17-jdk-slim AS build
WORKDIR /Link-Reduction
COPY . /Link-Reduction
RUN #./gradlew bootJar
WORKDIR /
ENTRYPOINT ["java","-jar","/Link-Reduction/build/libs/linkreduction.jar"]