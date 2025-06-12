# Etapa de construcción
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /vscodepruebavet
COPY . .
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim
WORKDIR /vscodepruebavet
COPY --from=build /vscodepruebavet/target/*.jar app_veterinaria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_veterinaria.jar"]