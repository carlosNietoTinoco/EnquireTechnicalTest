FROM maven:3.8.5-openjdk-17-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package

FROM azul/zulu-openjdk-alpine:17.0.11
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 56789
ENTRYPOINT ["java","-jar","app.jar"]
