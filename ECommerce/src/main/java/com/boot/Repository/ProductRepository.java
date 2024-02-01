package com.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.boot.ECommerce.*;
@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product save(Product existingproduct);}