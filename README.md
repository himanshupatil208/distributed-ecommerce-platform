# Distributed E-Commerce Platform (Microservices Architecture)

## Overview

This project is a distributed e-commerce platform built using Spring Boot microservices architecture. It demonstrates separation of concerns across multiple services such as product management, order processing, and inventory management, integrated through an API Gateway.

The system uses Spring Cloud Gateway (MVC-based routing) and all services communicate via REST APIs. Each service runs independently and can be deployed separately.

---

## Architecture

```text
Client
   ↓
API Gateway (Spring Cloud Gateway - RouterFunction)
   ↓
---------------------------------------------------
| Product Service   → http://localhost:8080       |
| Order Service     → http://localhost:8081       |
| Inventory Service → http://localhost:8082       |
---------------------------------------------------
```

### API Gateway

```text
http://localhost:9000
```

The API Gateway acts as a single entry point for all client requests and routes them to appropriate backend microservices.

---

## Tech Stack

* Java 8 / Java 17
* Spring Boot
* Spring Cloud Gateway
* Spring Web (REST APIs)
* Spring Data JPA
* MySQL
* Apache Tomcat
* Maven

---

## Microservices

### 1. Product Service

* Manages product catalog
* CRUD operations for products
* Provides REST APIs for product data

---

### 2. Order Service

* Handles order creation and processing
* Communicates with Product and Inventory services

---

### 3. Inventory Service

* Manages stock and inventory
* Validates product availability before order processing

---

### 4. API Gateway

* Central entry point for all requests
* Routes requests to appropriate microservices
* Built using Spring Cloud Gateway (RouterFunction-based configuration)
* Runs on port **9000**

---

## API Gateway Routes

All requests go through:

```text
http://localhost:9000
```

### Routes Mapping:

```text
/api/product/**     → Product Service (http://localhost:8080)
/api/order/**       → Order Service (http://localhost:8081)
/api/inventory/**   → Inventory Service (http://localhost:8082)
```

---

## How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/distributed-ecommerce-platform.git
cd distributed-ecommerce-platform
```

---

### 2. Start MySQL

Ensure MySQL is running and each service has correct DB configuration.

---

### 3. Run Microservices

Start services in this order:

1. Product Service → http://localhost:8080
2. Order Service → http://localhost:8081
3. Inventory Service → http://localhost:8082
4. API Gateway → http://localhost:9000

---

## API Testing Examples

### Through Services Directly:

**Product Service**

```text
GET http://localhost:8080/api/product/
```

**Order Service**

```text
POST http://localhost:8081/api/order/
```

**Inventory Service**

```text
GET http://localhost:8082/api/inventory/
```

---

### Through API Gateway (Recommended):

```text
GET http://localhost:9000/api/product/
POST http://localhost:9000/api/order/
GET http://localhost:9000/api/inventory/
```

---

## Project Structure

```text
distributed-ecommerce-platform/
│
├── api-gateway/
├── product-service/
├── order-service/
├── inventory-service/
│
├── README.md
└── .gitignore
```

---

## Important Notes

* No Eureka / Service Discovery is used
* Static routing is configured in API Gateway
* Each service runs independently on its own port
* Ensure ports 8080, 8081, 8082, and 9000 are free before running
* Communication is REST-based between services

---

## Future Improvements

* Add Eureka Service Discovery
* Introduce Docker & Docker Compose
* Implement Kafka for event-driven communication
* Add centralized logging (ELK stack)
* Add API documentation using Swagger/OpenAPI
* Implement Spring Security with JWT authentication

---

## Author

Himanshu Ambalal Patil
Java | Spring Boot | Microservices | Backend Developer
