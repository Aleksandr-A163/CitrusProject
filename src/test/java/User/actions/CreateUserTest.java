package User.actions;

import dto.NewUserDTO;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;
import static io.restassured.RestAssured.given;


import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest {

    @Test
    void createUser() throws InterruptedException {
        long expectedMessage = 408L;
        PetStoreApi api = new PetStoreApi();

        NewUserDTO userDTO = NewUserDTO.builder()
                .id(expectedMessage)
                .firstName("SomeUser")
                .userStatus(65L)
                .phone("89-9090909")
                .username("Kolya")
                .build();

        api.creteNewUser(userDTO)
                .statusCode(200)
                .body("message", equalTo(String.valueOf(expectedMessage)));

        // ⏳ Добавим паузу
        Thread.sleep(1000);

        api.deleteUser("Kolya")
                .statusCode(200);
    }


}
