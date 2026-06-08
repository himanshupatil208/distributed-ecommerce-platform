# Distributed E-Commerce Platform (Microservices Architecture)

## Overview

This project is a distributed e-commerce platform built using Spring Boot microservices architecture. It demonstrates separation of concerns across multiple services such as product management, order processing, and inventory management, integrated through an API Gateway.

The system uses Spring Cloud Gateway (MVC-based routing) with static service URLs and is deployed using Apache Tomcat.

---

## Architecture

Client
  ↓
API Gateway (Spring Cloud Gateway - MVC RouterFunction)
  ↓
---------------------------------------------------
| Product Service   → http://localhost:8080       |
| Order Service     → http://localhost:8081       |
| Inventory Service → http://localhost:8082       |
---------------------------------------------------

Note:
- No Eureka / Service Discovery is used
- Communication is handled via REST APIs
- Services are independently deployable

---

## Tech Stack

- Java 8 / Java 17
- Spring Boot
- Spring Cloud Gateway (MVC)
- Spring Web
- Spring Data JPA
- MySQL
- Apache Tomcat
- Maven

---

## Microservices

### Product Service
- Manages product catalog
- CRUD operations for products
- Provides REST APIs for product data

---

### Order Service
- Handles order creation and processing
- Communicates with product and inventory services

---

### Inventory Service
- Manages stock and inventory
- Validates product availability

---

### API Gateway
- Central entry point for all requests
- Routes requests to appropriate services
- Built using Spring Cloud Gateway (RouterFunction-based configuration)

---

## API Gateway Routes

- /api/product/** → http://localhost:8080
- /api/order/** → http://localhost:8081
- /api/inventory/** → http://localhost:8082

---

## How to Run the Project

### 1. Clone the repository
git clone https://github.com/your-username/distributed-ecommerce-platform.git
cd distributed-ecommerce-platform

---

### 2. Start MySQL
Make sure MySQL is running and configured for each service.

---

### 3. Run Microservices

Start services in the following order:

1. Product Service (localhost:8080)
2. Order Service (localhost:8081)
3. Inventory Service (localhost:8082)
4. API Gateway (last)

---

## API Testing Examples

Product Service:
GET http://localhost:8080/api/product/

Order Service:
POST http://localhost:8080/api/order/

Inventory Service:
GET http://localhost:8080/api/inventory/

---

## Project Structure

distributed-ecommerce-platform/
│
├── api-gateway/
├── product-service/
├── order-service/
├── inventory-service/
│
├── README.md
└── .gitignore

---

## Important Notes

- No Eureka or service discovery is used
- All services use static localhost URLs
- Each service runs independently on Tomcat ports
- Ensure ports 8080, 8081, 8082 are free before running

---

## Future Improvements

- Add Eureka Service Discovery
- Add Docker Compose for full orchestration
- Introduce Kafka for event-driven communication
- Add centralized logging (ELK stack)
- Add Swagger API documentation

---

## Author

Himanshu Ambalal Patil
Java | Spring Boot | Microservices | Backend Developer