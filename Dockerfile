# ─── ETAPA 1: BUILD ──────────────────────────────────────────────
FROM maven:3.9.4-eclipse-temurin-21  AS builder
WORKDIR /app

# 1) Copiamos pom.xml, mvnw y TODO el directorio .mvn
COPY pom.xml mvnw ./
COPY .mvn/ .mvn/

# 2) Damos permisos y bajamos dependencias con el wrapper
RUN chmod +x mvnw \
    && ./mvnw dependency:go-offline -B

# 3) Copiamos el resto del código y generamos el jar
COPY src/ src/
RUN ./mvnw clean verify

# ─── ETAPA 2: RUNTIME ────────────────────────────────────────────
FROM maven:3.9.4-eclipse-temurin-21
WORKDIR /app

# 4) Copiamos sólo el artefacto final
COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
