# 1. Estágio de Construção (Prepara o Maven e o Java 21)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
# Baixa as dependências e compila o seu projeto
RUN mvn clean package -DskipTests

# 2. Estágio de Execução (Roda o sistema leve e rápido)
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Copia o arquivo finalizado do estágio anterior
COPY --from=build /app/target/*.jar app.jar
# Libera a porta 8080 para a internet
EXPOSE 8080
# O comando do "Play"
ENTRYPOINT ["java", "-jar", "app.jar"]