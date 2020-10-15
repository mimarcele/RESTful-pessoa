package com.codigolimpo.controllers;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class EnderecoControllerTest {

   @Test   public void criar(){
         String url = "http://localhost:8080/endereco" ;
     
  String corpo =  "{\"endereco\": \"Rua Conde de Bonfim 621\"}";

        given().contentType("application/json").body("{\"endereco\": \"Rua Conde de Bonfim 621\"}")
                .when().post("http://localhost:8080/endereco")
               .then().statusCode(200).
               log().all();
   }
}
