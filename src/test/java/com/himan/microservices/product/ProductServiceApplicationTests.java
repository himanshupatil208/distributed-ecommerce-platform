package com.himan.microservices.product;

import com.himan.microservices.product.dto.ProductRequest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.mongodb.MongoDBContainer;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
    @LocalServerPort
    private Integer port;

    private final ObjectMapper objectMapper = new ObjectMapper();

    static {
        mongoDBContainer.start();
    }

    @BeforeEach
    void setup() {
        RestAssured.reset();
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        // important: avoids proxy-related issues
        RestAssured.proxy = null;
    }

    @Test
    void shouldCreateProduct() throws Exception {

        ProductRequest productRequest = getProductRequest();

        // Convert object → JSON (fixes serialization error)
        String requestBody = objectMapper.writeValueAsString(productRequest);

        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/product")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo(productRequest.name()))
                .body("description", Matchers.equalTo(productRequest.description()))
                .body("price", Matchers.equalTo(productRequest.price().intValueExact()));
    }

    private ProductRequest getProductRequest() {
        return new ProductRequest(
                "iPhone 13",
                "iPhone 13",
                BigDecimal.valueOf(1200)
        );
    }
}