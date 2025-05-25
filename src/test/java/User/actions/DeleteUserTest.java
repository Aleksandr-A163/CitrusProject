
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

    @Test
    void deleteExistingUser() {
        // Проверяет успешное удаление ранее созданного пользователя
        api.deleteUser(username)
                .statusCode(HttpStatus.SC_OK)
                .body("code", equalTo(200))
                .body("message", equalTo(username));
    }

    @Test
    void deleteNonExistentUser() {
        PetStoreApi api = new PetStoreApi();

        api.deleteUser("nonExistentUser")
            .statusCode(404); // и ничего больше
    }
}
