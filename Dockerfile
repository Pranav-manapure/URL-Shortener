FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build output to the container
COPY target/urlShortener-0.0.1-SNAPSHOT.jar urlShortner.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "urlShortner.jar"]