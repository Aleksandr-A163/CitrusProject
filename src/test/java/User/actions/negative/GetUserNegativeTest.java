package User.actions.negative;

import dto.NewUserDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;


public class GetUserNegativeTest {

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
     * Проверяет, что попытка получить несуществующего пользователя возвращает 404.
     */

    @Test
    void getNonExistentUser() {
        // Проверяет, что получение несуществующего пользователя возвращает 404
        api.getUser("ghost_user_404")
            .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
