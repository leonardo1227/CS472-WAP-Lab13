package edu.mum.cs.cs472wap.lab13.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private Integer id;
    private Double totalPrice;
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }
}
