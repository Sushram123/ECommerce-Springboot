package com.Ecommerce.controller;

import com.Ecommerce.model.Product;
import com.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

//    @PostMapping
//    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
//        try {
//            Product createdProduct = productService.createProduct(product);
//            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping("/{productId}")
    public ResponseEntity<Object> getProduct(@PathVariable String productId) {
        try {
            Product product = productService.getProductById(productId);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Object> updateProduct(@PathVariable String productId, @RequestBody Product product) {
        try {
            product.setProductId(productId);
            String message = productService.updateProduct(product);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String productId) {
        try {
            String message = productService.deleteProduct(productId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{productId}/apply")
    public ResponseEntity<Object> applyDiscountOrTax(@PathVariable String productId,
                                                     @RequestParam double discountOrTax,
                                                     @RequestParam boolean isDiscount) {
        try {
            Product product = productService.applyDiscountOrTax(productId, discountOrTax, isDiscount);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

