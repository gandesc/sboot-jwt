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
public class ProductControllerIT extends BaseIT {

    @Autowired
    ObjectMapper objectMapper;

    @DisplayName("List products")
    @Nested
    class ListProducts {
        @Test
        @WithUserDetails("admin")
        public void getProductsADMIN() throws Exception {
            mockMvc.perform(get("/products"))
                    .andExpect(status().isOk());
        }

        @Test
        @WithUserDetails("manager")
        public void getProductsMANAGER() throws Exception {
            mockMvc.perform(get("/products"))
                    .andExpect(status().isOk());
        }

        @Test
        public void getProductsNOAUTH() throws Exception {
            mockMvc.perform(get("/products"))
                    .andExpect(status().isUnauthorized());
        }
    }

    @DisplayName("Add product")
    @Nested
    class UpdateProduct {

        private Product productToAdd() {
            Random rand = new Random();

            return Product.builder()
                    .name(String.valueOf(rand.nextInt(99999999)))
                    .description(String.valueOf(rand.nextInt(99999999)))
                    .build();
        }

        @Test
        @WithUserDetails("admin")
        public void addProductADMIN() throws Exception {
            mockMvc.perform(post("/products")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(productToAdd())))
                    .andExpect(status().isOk());
        }

        @Test
        @WithUserDetails("manager")
        public void addProductMANAGER() throws Exception {
            mockMvc.perform(post("/products")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(productToAdd())))
                    .andExpect(status().isOk());
        }

        @Test
        public void addProductNOAUTH() throws Exception {
            mockMvc.perform(post("/products")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(productToAdd())))
                    .andExpect(status().isUnauthorized());
        }
    }

    @DisplayName("Delete product")
    @Nested
    class DeleteProduct {
        @Test
        @WithUserDetails("admin")
        public void deleteProductsADMIN() throws Exception {
            mockMvc.perform(delete("/products/1"))
                    .andExpect(status().isOk());
        }

        @Test
        @WithUserDetails("manager")
        public void deleteProductsMANAGER() throws Exception {
            mockMvc.perform(delete("/products/1"))
                    .andExpect(status().isForbidden());
        }

        @Test
        public void deleteProductsNOAUTH() throws Exception {
            mockMvc.perform(delete("/products/1"))
                    .andExpect(status().isUnauthorized());
        }
    }

}
