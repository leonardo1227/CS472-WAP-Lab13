package edu.mum.cs.cs472wap.lab13.model;

public class ShoppingCartItem {

    private Integer id;
    private Product product;
    private Integer quantity;
    private ShoppingCart shoppingCart;

    public ShoppingCartItem(Integer id, Product product, Integer quantity, ShoppingCart shoppingCart) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.shoppingCart = shoppingCart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
