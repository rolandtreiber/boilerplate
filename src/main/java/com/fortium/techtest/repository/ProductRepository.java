package com.fortium.techtest.repository;

import com.fortium.techtest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findBySku(String sku);

}
