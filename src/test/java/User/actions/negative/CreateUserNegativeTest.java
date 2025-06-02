package User.actions.negative;

import dto.NewUserDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;

/**
 * Негативные тесты создания пользователя
 */
public class CreateUserNegativeTest {

    @Test
    void createUserWithoutUsername() {
        PetStoreApi api = new PetStoreApi();

        NewUserDTO userDTO = NewUserDTO.builder()
                .id(1234L)
                .firstName("MissingUsername")
                .userStatus(1L)
                .phone("123456789")
                // username отсутствует
                .build();

        api.creteNewUser(userDTO)
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
