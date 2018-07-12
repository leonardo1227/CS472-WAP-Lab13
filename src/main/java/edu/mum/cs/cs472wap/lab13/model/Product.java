package edu.mum.cs.cs472wap.lab13.model;

public class Product {

    private Integer id;
    private String description;
    private Double price;
    private String picture;

    public Product(Integer id, String description, Double price, String picture) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
