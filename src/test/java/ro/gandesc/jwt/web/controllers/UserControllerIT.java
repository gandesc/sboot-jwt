package ro.gandesc.jwt.web.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserControllerIT extends BaseIT {

    @DisplayName("Get user")
    @Nested
    class GetAuthenticatedUser {
        @Test
        @WithUserDetails("admin")
        public void getUserADMIN() throws Exception {
            mockMvc.perform(get("/users/authenticated"))
                    .andExpect(status().isOk());
        }

        @Test
        public void getUserNOAUTH() throws Exception {
            mockMvc.perform(get("/users/authenticated"))
                    .andExpect(status().isUnauthorized());
        }
    }
}
