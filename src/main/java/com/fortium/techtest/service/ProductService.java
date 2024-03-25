package com.fortium.techtest.service;

import com.fortium.techtest.DAO.ProductDAO;
import com.fortium.techtest.entity.Product;
import com.fortium.techtest.exception.ProductNotFoundException;
import com.fortium.techtest.repository.ProductRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDAO create(Product product) {
        return this.productRepository.save(product).toProductDao();
    }

    public ProductDAO findBySKU(String sku) throws ProductNotFoundException {
        try {
            Product product = productRepository.findBySku(sku);
            return new ProductDAO(product);
        } catch (DataAccessException exception) {
            throw new ProductNotFoundException();
        }
    }

}
