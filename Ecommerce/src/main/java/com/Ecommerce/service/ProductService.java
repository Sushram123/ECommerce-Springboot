package com.Ecommerce.service;

import com.Ecommerce.model.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(String productId);
    String updateProduct(Product product);
    String deleteProduct(String productId);
    Product applyDiscountOrTax(String productId, double discountOrTax, boolean isDiscount);
}