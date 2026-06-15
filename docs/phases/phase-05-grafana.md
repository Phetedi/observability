# Phase 05 - Grafana Dashboards

Reference Document:
Architecture Overview (../architecture.md)

## Objective

Visualize Spring Boot application metrics collected by Prometheus through Grafana dashboards.

The goal was to build operational dashboards that provide real-time visibility into:

- Application Health
- JVM Performance
- HTTP Requests
- Application Uptime
- Resource Utilization

---

## Environment

### Monitoring Stack

- Grafana
- Prometheus
- Spring Boot Application
- Docker

### Data Flow

Spring Boot Application
        |
        v
/actuator/prometheus
        |
        v
Prometheus
        |
        v
Grafana

---

## Grafana Access

URL:

http://<SERVER-IP>:3000

Default Credentials:

Username: admin
Password: admin

---

## Data Source Configuration

Prometheus configured as Grafana datasource.

Datasource URL:

http://prometheus:9090

Connection Status:

Successfully connected.

---

## Dashboard Created

Dashboard Name:

Spring Boot Overview

---

## Dashboard Panels

### Application Uptime

Metric:

process_uptime_seconds

Visualization:

Stat

Purpose:

Displays application runtime.

---

### JVM Heap Memory Usage

Metric:

jvm_memory_used_bytes

Visualization:

Time Series

Purpose:

Monitor JVM heap consumption.

---

### JVM Maximum Heap

Metric:

jvm_memory_max_bytes

Visualization:

Time Series

Purpose:

Compare current memory usage with maximum allocated memory.

---

### Live JVM Threads

Metric:

jvm_threads_live_threads

Visualization:

Time Series

Purpose:

Monitor active application threads.

---

### HTTP Request Rate

Metric:

rate(http_server_requests_seconds_count[1m])

Visualization:

Time Series

Purpose:

Track application request volume.

---

### Application Startup Time

Metric:

application_started_time_seconds

Visualization:

Stat

Purpose:

Measure startup performance.

---

### Application Readiness Time

Metric:

application_ready_time_seconds

Visualization:

Stat

Purpose:

Monitor readiness performance.

---

## Dashboard Validation

Verified:

- Metrics visible in Grafana
- Prometheus datasource operational
- Real-time updates functioning
- Dashboard persisted after restart

---

## Troubleshooting Performed

### Initial Metric Discovery

Used Grafana Explore to verify metric availability.

Examples:

jvm_memory_used_bytes

process_uptime_seconds

http_server_requests_seconds_count

---

### Validation Steps

Verified:

Prometheus Targets:

springboot-app -> UP

Metrics Endpoint:

http://localhost:8080/actuator/prometheus

Datasource Health:

Grafana successfully queried Prometheus.

---

## Skills Practiced

- Grafana Dashboard Creation
- PromQL Queries
- Metric Discovery
- Dashboard Visualization
- Monitoring Architecture
- Application Observability

---

## Lessons Learned

- Grafana visualizes metrics collected by Prometheus.
- PromQL is used to query time-series data.
- Spring Boot Actuator provides rich JVM and application metrics.
- Effective dashboards focus on operational visibility rather than displaying every available metric.
- Grafana and Prometheus together provide a complete observability platform.

---

## Outcome

Successfully created Grafana dashboards to monitor the Spring Boot application.

The monitoring stack now provides:

- Application Monitoring
- JVM Monitoring
- Request Monitoring
- Health Monitoring
- Operational Visibility

Status: Completed
