# Etapa 1: build usando Maven e Java 21
FROM maven:3.9.11-amazoncorretto-21-alpine AS build
WORKDIR /app

# Copia o projeto para dentro da imagem
COPY pom.xml .
COPY src ./src

# Compila o projeto e empacota sem rodar testes
RUN mvn clean package -DskipTests

# Etapa 2: imagem final para executar o app
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia o jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para executar o app
ENTRYPOINT ["java", "-jar", "app.jar"]