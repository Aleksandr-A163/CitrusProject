package services;

import dto.NewUserDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;

public class PetStoreApi {

    private RequestSpecification spec;


    public PetStoreApi(){
        spec = given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON);
    }

    public ValidatableResponse creteNewUser(NewUserDTO userDTO){

     return given(spec)
                .basePath("/user")
                .body(userDTO)
                .log().all()
                .when()
                .post()
                .then()
                .log().all();
    }

    public ValidatableResponse deleteUser(String userName){

        return given(spec)
                .basePath("/user/{username}")
                .pathParam("username", userName)
                .log().all()
                .when()
                .delete()
                .then()
                .log().all();
    }

}
