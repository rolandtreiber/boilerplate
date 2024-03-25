package com.fortium.techtest.entity;

import com.fortium.techtest.DAO.ProductDAO;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="short_description")
    private String shortDescription;
    @Column(name="description")
    private String description;
    @Column(name="sku")
    private String sku;
    @Column(name="price")
    private Float price;

    public ProductDAO toProductDao()
    {
        return new ProductDAO(this);
    }

    public Product(String name, String shortDescription, String description, String sku, Float price) {
        this.name = name;
        this.sku = sku;
        this.shortDescription = shortDescription;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
