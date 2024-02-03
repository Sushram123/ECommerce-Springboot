package com.Ecommerce.service;

import com.Ecommerce.model.Product;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductServiceImplementation implements ProductService {

    private final Map<String, Product> products = new HashMap<>();

    @Override
    public Product createProduct(Product product) {
        if (product == null || product.getName() == null || product.getDescription() == null) {
            throw new IllegalArgumentException("Product details cannot be null");
        }

        String productId = generateProductId();
        product.setProductId(productId);
        products.put(productId, product);
        return product;
    }

    @Override
    public Product getProductById(String productId) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
        return products.get(productId);
    }

    @Override
    public String updateProduct(Product product) {
        if (product == null || !products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product not found or details are invalid");
        }
        products.put(product.getProductId(), product);
        return "Product updated successfully";
    }

    @Override
    public String deleteProduct(String productId) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
        products.remove(productId);
        return "Product deleted successfully";
    }

    @Override
    public Product applyDiscountOrTax(String productId, double discountOrTax, boolean isDiscount) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
        Product product = products.get(productId);
        double price = product.getPrice();
        if (isDiscount) {
            double discountedPrice = price * (1 - (discountOrTax / 100));
            product.setPrice(discountedPrice);
        } else {
            double tax = price * (discountOrTax / 100);
            product.setPrice(price + tax);
        }
        return product;
    }

    private String generateProductId() {
        return UUID.randomUUID().toString();
    }
}
