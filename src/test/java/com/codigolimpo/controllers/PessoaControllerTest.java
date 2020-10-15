//package com.codigolimpo.controllers;
//
//import net.bytebuddy.NamingStrategy;
//import org.junit.jupiter.api.Test;
//import org.mockito.BDDMockito;
//import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.given;
//
//public class PessoaControllerTest {
//
//    @Test
//    void criar() {
//        String url = "http://localhost:8080/pessoa";
//        String corpo = "{\"nome\": \"Milena Marcele\"}";
//
//        //Dado que
//        //Quando tiver
//        //Então resultado esperado
//                 given().contentType("application/json").body(corpo).
//                when().post(url).
//                then().statusCode(200);
//    }
//    @Test
//    void listar(){
//        when()
//                .get("http://localhost:8080/pessoa")
//                .then().statusCode(200);
//    }
//    @Test
//    void consultar(){
//        String url = "http://localhost:8080/pessoa/6";
//
//        given().contentType("application/json")
//                .when().get(url)
//                .then().statusCode(200);
//
//    }
//
//}