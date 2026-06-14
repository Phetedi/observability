Phase 04 - Prometheus Integration

Reference Document
Architecture Overview (../architecture.md)

Objective

Integrate the Spring Boot application with Prometheus to enable application-level monitoring and observability.

The goal was to expose application metrics through Spring Boot Actuator, configure Prometheus to scrape those metrics, and validate end-to-end monitoring functionality.

Environment
Host
Oracle Linux 9
Docker Engine
Monitoring Stack
Prometheus
Grafana
Node Exporter
Application
Spring Boot
Java 17
Maven
Docker
Initial State

The application exposed:

/health
/version
/info
/actuator/health

Prometheus metrics endpoint was unavailable.

Verification:

curl localhost:8080/actuator/prometheus

Result:

404 Not Found
Adding Prometheus Metrics Support
pom.xml Update

Added Micrometer Prometheus Registry dependency:

<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
Application Configuration

Updated:

management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
management.prometheus.metrics.export.enabled=true
Application Rebuild

Rebuilt application:

mvn clean package

Generated updated application JAR.

Docker Image Rebuild

Built new image:

docker build -t observability-api:1.1 .
Container Deployment

Removed existing container:

docker stop observability-api
docker rm observability-api

Started updated container:

docker run -d \
--name observability-api \
-p 8080:8080 \
observability-api:1.1
Metrics Endpoint Verification

Verification:

curl localhost:8080/actuator/prometheus

Result:

# HELP application_ready_time_seconds
# TYPE application_ready_time_seconds gauge
...

Prometheus metrics successfully exposed.

Prometheus Configuration

Added new scrape job:

- job_name: 'springboot-app'

  metrics_path: '/actuator/prometheus'

  static_configs:
    - targets:
      - 'observability-api:8080'
Initial Failure

Prometheus target status:

DOWN

Error:

context deadline exceeded
Troubleshooting Process
Investigation

Verified:

Application endpoint accessible from host
Metrics endpoint functional
Container healthy

Checked Docker networking:

docker inspect prometheus
docker inspect observability-api

Findings:

Prometheus Network:
observability

Spring Boot Network:
bridge
Root Cause

Containers were attached to different Docker networks.

Prometheus could not communicate with the application container.

Resolution

Connected application container to monitoring network:

docker network connect observability observability-api

Updated Prometheus configuration to use container DNS name:

targets:
  - 'observability-api:8080'

Avoided using dynamic container IP addresses.

Validation

Prometheus Targets Page:

springboot-app
UP

Verification:

curl localhost:8080/actuator/prometheus

Result:

Application metrics available and actively scraped by Prometheus.

Docker Compose Improvement

Migrated Spring Boot application into docker-compose.yml.

Added service:

observability-api:
  build:
    context: ./applications/springboot-app/demo

  image: observability-api:1.1

  container_name: observability-api

  restart: unless-stopped

  ports:
    - "8080:8080"

  networks:
    - observability

Benefits:

Consistent deployments
Shared networking
Easier maintenance
Better CI/CD integration
Simpler migration to Kubernetes
Metrics Available

Examples of collected metrics:

JVM Metrics
JVM Memory Usage
JVM Threads
JVM Classes
JVM GC Activity
Application Metrics
Application Startup Time
Application Readiness
Application Health
HTTP Metrics
Request Count
Response Status Codes
Request Duration
System Metrics
Disk Space
Executor Threads
Process Metrics
Lessons Learned
Spring Boot requires Micrometer Prometheus Registry to expose Prometheus metrics.
Docker container networking directly impacts monitoring visibility.
Container names provide more reliable service discovery than container IP addresses.
Docker Compose simplifies operational management.
Prometheus target troubleshooting should begin with endpoint verification and network inspection.
Outcome

Successfully integrated Spring Boot application metrics with Prometheus.

Prometheus is now collecting application telemetry that will be visualized in Grafana during Phase 05.

Status: Completed
