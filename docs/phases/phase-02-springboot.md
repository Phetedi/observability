Reference Document:
[Architecture Overview](../architecture.md)

Phase 02 - Spring Boot Application
Objective

Create a Java Spring Boot application that will serve as the monitored workload for the observability platform.

Environment
Java: OpenJDK 17
Maven: 3.6.3
Spring Boot: Generated using Spring Initializr
Application Components
Dependencies
Spring Web
Spring Boot Actuator
REST Endpoints
Health Endpoint
GET /health

Response:

Application Running
Version Endpoint
GET /version
Info Endpoint
GET /info
Actuator

Enabled management endpoints:

management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always

Health endpoint verification:

GET /actuator/health

Status:

{
  "status": "UP"
}
Build Process

Compile and package:

mvn clean package

Run application:

java -jar target/*.jar
Validation

Application endpoint:

curl localhost:8080/health

Result:

Application Running

Actuator endpoint:

curl localhost:8080/actuator/health

Result:

{
  "status": "UP"
}
Outcome

A working Spring Boot application is available for future integration with Docker, Prometheus, Grafana, Jenkins, Kubernetes, and Ansible.
