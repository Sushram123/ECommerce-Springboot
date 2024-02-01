package com.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ECommerce.Product;
import com.boot.Service.ProductService;
import com.boot.Repository.*;

@RestController

@RequestMapping("/api/v1") 

public class ProductController { 

  

    private final ProductService productService;
    private ProductRepository productRepository = null;

  

    public ProductController(ProductService productService) 

    { 

        this.productService = productService; 
        this.productRepository=productRepository;

    }
 // Create a new product 

    @PostMapping("/product") 

    public ResponseEntity<Product> saveProduct(@RequestBody Product product) 
    { 

        Product newProduct =  productRepository.save(product); 

        return ResponseEntity.ok(newProduct); 
    }
 // Get all products 

    @GetMapping("/products")  

    public List<Product> getAllProducts() 
    { 

        return (List<Product>) productService.fetchAllProducts(); 
    }
 // Get a product by ID 

    @GetMapping("/products/{id}") 

    public ResponseEntity<ResponseEntity<Optional<Product>>> getProductById(@PathVariable Long id) 
    { 

        ResponseEntity<Optional<Product>> product = productService.fetchProductById(id); 

        if (product != null) { 

            return ResponseEntity.ok(product); 

        } 

        else { 

            return ResponseEntity.notFound().build(); 

        } 
    }
    
 // Update a product 

    @PutMapping(path = "/products/{productId}") 

    public ResponseEntity<Product> updateProduct(@PathVariable(value = "productId") 

                  Long productId, @RequestBody Product product) 
    { 

        return productService.updateProduct(productId, product); 
    }
 // Delete a product 

    @DeleteMapping(value = "/products/{productId}") 

    public String deleteProduct(@PathVariable Long productId) 
    { 

        productService.deleteProduct(productId); 

        return "Product Deleted Successfully against id "

            + productId + " "; 
    }
    
    
}