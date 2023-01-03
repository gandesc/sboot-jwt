package ro.gandesc.jwt.web.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ProductControllerTest extends BaseIT {


    @DisplayName("List products")
    @Nested
    class ListProducts {
        @Test
        @WithUserDetails("admin")
        public void getProductsAUTH() throws Exception {
            mockMvc.perform(get("/products"))
                    .andExpect(status().isOk());
        }

        @Test
        public void getProductsNOAUTH() throws Exception {
            mockMvc.perform(get("/products"))
                    .andExpect(status().isUnauthorized());
        }
    }

    @DisplayName("Delete product")
    @Nested
    class AddProduct {
        @Test
        @WithUserDetails("admin")
        public void deleteProductsAUTH() throws Exception {
            mockMvc.perform(delete("/products/1"))
                    .andExpect(status().isOk());
        }

        @Test
        public void deleteProductsNOAUTH() throws Exception {
            mockMvc.perform(delete("/products/1"))
                    .andExpect(status().isUnauthorized());
        }
    }



}
