package ro.gandesc.jwt.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import ro.gandesc.jwt.domain.Product;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserControllerIT extends BaseIT {

    @DisplayName("Get user")
    @Nested
    class ListProducts {
        @Test
        @WithUserDetails("admin")
        public void getProductsADMIN() throws Exception {
            mockMvc.perform(get("/user"))
                    .andExpect(status().isOk());
        }

        @Test
        public void getProductsNOAUTH() throws Exception {
            mockMvc.perform(get("/user"))
                    .andExpect(status().isUnauthorized());
        }
    }
}
