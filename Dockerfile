# ---------- Build stage ----------
# Use Maven with JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy Maven config and source code
COPY pom.xml .
COPY src ./src

# Build the Spring Boot jar
RUN mvn -DskipTests package

# ---------- Run stage ----------
# Use JRE/JDK 21 to run the app
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
