package com.fortium.techtest.controller;

import com.fortium.techtest.DAO.ProductDAO;
import com.fortium.techtest.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private ResponseEntity<Void> entityWithLocation(Object sku) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("products/{sku}").buildAndExpand(sku).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{sku}")
    public ProductDAO findBySku(@PathVariable String sku) {
        return productService.findBySKU(sku);
    }

    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody ProductDAO productDAO) {
        ProductDAO product = productService.create(productDAO.productEntity());
        return entityWithLocation(product.getSku());
    }

}
