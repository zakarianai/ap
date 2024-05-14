# Use OpenJDK 17 as the base image
FROM openjdk:17-oracle
WORKDIR /app
# Copy the compiled JAR file into the container at /app
COPY target/gestio_parking-0.0.1-SNAPSHOT.jar /app/gestio_parking-0.0.1-SNAPSHOT.jar
# Expose the port that your Spring Boot application runs on
EXPOSE 8080
# Define the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "gestio_parking-0.0.1-SNAPSHOT.jar"]