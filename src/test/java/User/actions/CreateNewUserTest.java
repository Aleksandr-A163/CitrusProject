package User.actions;

import dto.NewUserDTO;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;

import static org.hamcrest.Matchers.equalTo;

public class CreateNewUserTest {

    @Test
    void createUser() {
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
                .statusCode(HttpStatus.SC_OK)
                //.time(lessThan(1000L))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreateUser.json"))
                .body("type", equalTo("unknown"))
                .body("code", equalTo(200))
                .body("message", equalTo("408"));

       /* NewUserResponseDTO actualUser = api.creteNewUser(userDTO)
                .extract().body().as(NewUserResponseDTO.class);

        String actualMessage = api.creteNewUser(userDTO).extract()
                .body().jsonPath().get("message");

        Assertions.assertEquals(Long.toString(expectedMessage), actualMessage, "Incorrect message");
*/
        api.deleteUser("Sasha")
                .statusCode(HttpStatus.SC_OK);

   /*     Assertions.assertAll("Check crete new user",
                () -> Assertions.assertEquals(actualUser.getCode(), 200, "Incorrect code"),
                () -> Assertions.assertEquals(actualUser.getMessage(), "408", "Incorrect message"),
                () -> Assertions.assertEquals(actualUser.getType(), "unknown", "Incorrect type")
        );*/
    }

   /* private Stream<Arguments> dataProvider(){
        NewUserDTO userDTO = NewUserDTO.builder()
                .id(408L)
                .firstName("SomeUser")
                .userStatus(65L)
                .phone("89-9090909")
                .username("Kolya")
                .build();

        NewUserDTO userNoIdDTO = NewUserDTO.builder()
                .firstName("SomeUser")
                .userStatus(65L)
                .phone("89-9090909")
                .username("Kolya")
                .build();

        NewUserDTO userNoFirstNameDTO = NewUserDTO.builder()
                .id(408L)
                .userStatus(65L)
                .phone("89-9090909")
                .username("Kolya")
                .build();

        return  Stream.of(
                Arguments.of(userDTO),
                Arguments.of(userNoFirstNameDTO),
                Arguments.of(userNoIdDTO)
        );
    }*/
}
