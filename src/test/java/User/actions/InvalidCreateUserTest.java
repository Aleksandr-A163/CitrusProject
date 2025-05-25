
package User.actions;

import dto.NewUserDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import services.PetStoreApi;

public class InvalidCreateUserTest {

    @Test
    void createUserWithMissingUsername() {
        // Проверяет отклонение запроса при отсутствии обязательного поля username
        PetStoreApi api = new PetStoreApi();

        NewUserDTO userDTO = NewUserDTO.builder()
                .id(1234L)
                .firstName("NoUsername")
                .userStatus(0L)
                .phone("000-0000")
                .build(); // отсутствует username

        api.creteNewUser(userDTO)
                .statusCode(HttpStatus.SC_BAD_REQUEST); // предполагаем, что сервер вернет 400
    }
}
