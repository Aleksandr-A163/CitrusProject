
package User.actions;

import dto.NewUserDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;

import static org.hamcrest.Matchers.equalTo;

public class DeleteUserTest {

    private PetStoreApi api;
    private final String username = "UserToDelete";

    /**
     * Создаёт пользователя с именем UserToDelete перед каждым тестом.
     */

    @BeforeEach
    void setUp() {
        api = new PetStoreApi();
        NewUserDTO userDTO = NewUserDTO.builder()
                .id(9999L)
                .firstName("ToDelete")
                .userStatus(1L)
                .phone("123-456")
                .username(username)
                .build();
        api.creteNewUser(userDTO).statusCode(HttpStatus.SC_OK);

    }

    /**
     * Проверяет, что ранее созданный пользователь успешно удаляется.
     * Ожидается: статус 200 и тело ответа содержит code=200 и message=username.
     */

    @Test
    void deleteExistingUser() {
        // Проверяет успешное удаление ранее созданного пользователя
        api.deleteUser(username)
                .statusCode(HttpStatus.SC_OK)
                .body("code", equalTo(200))
                .body("message", equalTo(username));
    }

    /**
     * Проверяет, что при попытке удалить несуществующего пользователя сервер возвращает 404.
     */

    @Test
    void deleteNonExistentUser() {
        PetStoreApi api = new PetStoreApi();

        api.deleteUser("nonExistentUser")
            .statusCode(404); // и ничего больше
    }
}
