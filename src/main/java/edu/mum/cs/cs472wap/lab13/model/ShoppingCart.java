package edu.mum.cs.cs472wap.lab13.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private Long id;
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public Double getTotalPrice(){
        return items.stream().map(x -> x.getTotalPrice()).reduce(0.0,Double::sum);
    }
}
