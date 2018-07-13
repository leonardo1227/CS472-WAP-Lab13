package edu.mum.cs.cs472wap.lab13.model;

public class ShoppingCartItem {

    private Integer id;
    private Product product;
    private Integer quantity;
    private Double totalPrice;
    private ShoppingCart shoppingCart;

    public ShoppingCartItem(Integer id) {
        this.id = id;
    }

    public ShoppingCartItem(Integer id, Product product, Integer quantity, ShoppingCart shoppingCart) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = this.product.getPrice()*this.getQuantity();
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
