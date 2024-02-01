package com.boot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.Repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

import com.boot.ECommerce.*;
@Service

public class ProductService { 

    private final ProductRepository productRepository; 

  

    public ProductService( 

        ProductRepository productRepository) 

    { 

        this.productRepository = productRepository; 

    } 
    
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) 
    { 

        Product newProduct = productRepository.save(product); 

        return ResponseEntity.ok(newProduct); 
    }
 // Get all products 

    public ResponseEntity<List<Product> > fetchAllProducts() 
    { 

        return ResponseEntity.ok(productRepository.findAll()); 
    }
 // Get a product by ID 

    public ResponseEntity<Optional<Product> > 
    fetchProductById(Long id) 
    { 

        Optional<Product> product 

            = productRepository.findById(id); 

        if (product.isPresent()) { 

            return ResponseEntity.ok(product); 

        } 

        else { 

            return ResponseEntity.notFound().build(); 

        } 
    }
    public ResponseEntity<Product> updateProduct(Long id, Product updatedProduct) 
    { 

        if (id == null) { 

            throw new IllegalArgumentException( 

                "ID cannot be null"); 

        } 

        Product Existingproduct 

            = productRepository.findById(id).orElseThrow( 

                () 

                    -> new EntityNotFoundException( 

                        String.valueOf(id))); 

        Existingproduct.setName(updatedProduct.getName()); 

        Existingproduct.setPrice(updatedProduct.getPrice()); 

        Existingproduct.setQuantityAvailable( 

            updatedProduct.getQuantityAvailable()); 

        Product savedEntity 

            = productRepository.save(Existingproduct); 

        return ResponseEntity.ok(savedEntity); 
    }
    public ResponseEntity<String> deleteProduct(Long id) 
    { 

        productRepository.deleteById(id); 

        return ResponseEntity.ok( 

            "Product Deleted Successfully"); 
    }
}