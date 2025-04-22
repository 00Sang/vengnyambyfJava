# Use an official OpenJDK runtime as a base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file to the container (assumes you build the JAR externally using Maven/Gradle)
COPY target/app.jar app.jar

# Expose the application's port
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "app.jar"]