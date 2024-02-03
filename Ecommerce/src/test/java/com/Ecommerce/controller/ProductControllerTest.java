package com.Ecommerce.controller;

import com.Ecommerce.model.Product;
import com.Ecommerce.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createProduct() throws Exception {
        Product product = new Product("Book A", "Fiction book", 25.99, 100);
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Book A\",\"description\":\"Fiction book\",\"price\":25.99,\"quantityAvailable\":100}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Book A"))
                .andExpect(jsonPath("$.description").value("Fiction book"))
                .andExpect(jsonPath("$.price").value(25.99))
                .andExpect(jsonPath("$.quantityAvailable").value(100));
    }

    @Test
    void getProduct() throws Exception {
        Product product = new Product("Book A", "Fiction book", 25.99, 100);
        when(productService.getProductById("123456")).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/123456")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Book A"))
                .andExpect(jsonPath("$.description").value("Fiction book"))
                .andExpect(jsonPath("$.price").value(25.99))
                .andExpect(jsonPath("$.quantityAvailable").value(100));
    }

    @Test
    void updateProduct() throws Exception {
        Product product = new Product("Book A", "Fiction book", 25.99, 100);
        when(productService.updateProduct(any(Product.class))).thenReturn("Product updated successfully");

        mockMvc.perform(MockMvcRequestBuilders.put("/products/123456")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Book A\",\"description\":\"Fiction book\",\"price\":25.99,\"quantityAvailable\":100}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Product updated successfully"));
    }

    @Test
    void deleteProduct() throws Exception {
        when(productService.deleteProduct("123456")).thenReturn("Product deleted successfully");

        mockMvc.perform(MockMvcRequestBuilders.delete("/products/123456")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Product deleted successfully"));
    }

    @Test
    void applyDiscountOrTax() throws Exception {
        Product product = new Product("Book A", "Fiction book", 25.99, 100);
        when(productService.applyDiscountOrTax("123456", 10, true)).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/123456/apply?discountOrTax=10&isDiscount=true")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Book A"))
                .andExpect(jsonPath("$.description").value("Fiction book"))
                .andExpect(jsonPath("$.price").value(25.99))
                .andExpect(jsonPath("$.quantityAvailable").value(100));
    }
}
