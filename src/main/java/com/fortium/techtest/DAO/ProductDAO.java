package com.fortium.techtest.DAO;

import com.fortium.techtest.entity.Product;
import jakarta.persistence.Column;

public class ProductDAO {

    private Long id;
    private String name;
    private String shortDescription;
    private String description;
    private String sku;
    private Float price;

    public ProductDAO() {
    }

    public ProductDAO(Product product) {
        this.name = product.getName();
        this.shortDescription = product.getShortDescription();
        this.description = product.getDescription();
        this.sku = product.getSku();
        this.price = product.getPrice();
    }

    public Product productEntity() {
        return new Product(this.name, this.shortDescription, this.description, this.sku, this.price);
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                '}';
    }
}
