package ch.erard22.thorntail.demo.integrationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;

class HelloEndpointIT {


    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }


    @Test
    void callEcho() {
        Response response = RestAssured.get("/hello/donald");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getBody().print(), "EchoResponse: donald");
    }


}
