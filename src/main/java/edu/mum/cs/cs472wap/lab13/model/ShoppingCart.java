package edu.mum.cs.cs472wap.lab13.model;

import java.util.List;

public class ShoppingCart {

    private Integer id;
    private List<ShoppingCartItem> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

}
