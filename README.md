# Forex Microservices Project V2

This project is a set of microservices for a Forex trading application. It includes services for forex rates, forex conversion, an API gateway, a naming server, and a Zipkin server for distributed tracing.

## Technologies Used

- Java
- Spring Boot
- Maven
- SQL
- Docker
- Eureka (Netflix OSS)
- Zipkin

## Services

### Forex Rates Service

Provides current forex rates.

- **Port:** 9000
- **Docker Image:** `uday07/miv2-forex-rates-service:0.0.1-SNAPSHOT`

### Forex Converter Service

Converts amounts between different currencies using current forex rates.

- **Port:** 8000
- **Docker Image:** `uday07/miv2-forex-converter-service:0.0.1-SNAPSHOT`

### API Gateway

Routes requests to the appropriate microservice.

- **Port:** 8765
- **Docker Image:** `uday07/miv2-api-gateway:0.0.1-SNAPSHOT`

### Naming Server

Service registry using Eureka.

- **Port:** 8761
- **Docker Image:** `uday07/miv2-naming-server:0.0.1-SNAPSHOT`
- [Explore Eureka](http://localhost:8761/)

### Zipkin Server

Distributed tracing server.

- **Port:** 9411
- **Docker Image:** `openzipkin/zipkin:3`
- [Explore Zipkin](http://localhost:9411/zipkin/)

## Prerequisites

- Docker
- Docker Compose
- Java 21
- Maven

## Running the Application

   ```sh
   
   docker-compose up
   ````

## 🚀 Explore the APIs On PostMan
[👉 Click here to explore](https://www.postman.com/planetary-water-884580/workspace/uday-s-public-workspace/collection/1581944-86c7893b-72a2-4276-ab02-b5555de514e9?action=share&creator=1581944)