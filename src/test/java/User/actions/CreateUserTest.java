package User.actions;

import dto.NewUserDTO;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;



import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest {

    /**
     * Проверяет успешное создание нового пользователя с заданным ID.
     * Ожидается, что API вернёт код 200 и в теле ответа message будет содержать переданный ID.
     */

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
                .statusCode(200)
                .body("message", equalTo(String.valueOf(expectedMessage)));

    }


}
