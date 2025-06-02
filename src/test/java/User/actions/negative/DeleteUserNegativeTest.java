package User.actions.negative;

import dto.NewUserDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;


public class DeleteUserNegativeTest {

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
    void deleteNonExistentUser() {
        PetStoreApi api = new PetStoreApi();

        api.deleteUser("nonExistentUser")
            .statusCode(404); // и ничего больше
    }
}
