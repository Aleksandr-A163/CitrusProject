package User.actions.positive;

import dto.NewUserDTO;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserPositiveTest {

    /**
     * Проверяет успешное создание нового пользователя с заданным ID,
     * а затем получение этого пользователя через GET-запрос.
     */
    @Test
    void createUser() {
        long expectedId = 408L;
        String expectedUsername = "Kolya";

        PetStoreApi api = new PetStoreApi();

        NewUserDTO userDTO = NewUserDTO.builder()
                .id(expectedId)
                .firstName("SomeUser")
                .userStatus(65L)
                .phone("89-9090909")
                .username(expectedUsername)
                .build();

        // Шаг 1: Создание пользователя
        api.creteNewUser(userDTO)
                .statusCode(200)
                .body("message", equalTo(String.valueOf(expectedId)));

        // Шаг 2: Получение пользователя и проверка полей
        api.getUser(expectedUsername)
                .statusCode(200)
                .body("id", equalTo((int) expectedId))
                .body("username", equalTo(expectedUsername))
                .body("firstName", equalTo("SomeUser"))
                .body("userStatus", equalTo(65))
                .body("phone", equalTo("89-9090909"));
    }
}
