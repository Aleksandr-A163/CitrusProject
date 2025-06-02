package User.actions.positive;

import dto.NewUserDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetUserPositiveTest {

    private PetStoreApi api;
    private final String username = "ExistingUser";

    /**
     * Создаёт нового пользователя перед каждым тестом.
     * Объект используется в тесте получения данных по username.
     */

    @BeforeEach
    void setUp() {
        api = new PetStoreApi();

        // Создаём пользователя, чтобы получить его позже
        NewUserDTO userDTO = NewUserDTO.builder()
                .id(5555L)
                .firstName("Gettable")
                .userStatus(2L)
                .phone("123456789")
                .username(username)
                .build();
        api.creteNewUser(userDTO).statusCode(HttpStatus.SC_OK);
    }

    /**
     * Проверяет, что ранее созданный пользователь доступен по GET-запросу.
     * Ожидается: статус 200, username совпадает и id присутствует.
     */

    @Test
    void getExistingUser() {
        // Проверяет, что можно получить ранее созданного пользователя
        api.getUser(username)
                .statusCode(HttpStatus.SC_OK)
                .body("username", equalTo(username))
                .body("id", notNullValue());
    }

}


    