Reference Document:
[Architecture Overview](../architecture.md)

Phase 03 - Docker Containerization

Reference Document:
Architecture Overview

Objective

Containerize the Spring Boot application and execute it using Docker.

Environment
Oracle Linux 9
Docker Engine
Java 17
Spring Boot Application
Dockerfile
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
Build Process

Build image:

docker build -t observability-api:1.0 .

Verify image:

docker images
Container Execution

Run:

docker run -d \
--name observability-api \
-p 8080:8080 \
observability-api:1.0
Validation

Health endpoint:

curl localhost:8080/health

Actuator endpoint:

curl localhost:8080/actuator/health
Outcome

Successfully containerized the Spring Boot application and verified that the application can run independently of the host operating system.

This container image will be used in future phases for:

Prometheus monitoring
Grafana dashboards
Jenkins pipelines
Kubernetes deployments
