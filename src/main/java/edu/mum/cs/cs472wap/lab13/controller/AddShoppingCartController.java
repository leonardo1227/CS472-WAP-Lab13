package edu.mum.cs.cs472wap.lab13.controller;

import edu.mum.cs.cs472wap.lab13.database.DataBase;
import edu.mum.cs.cs472wap.lab13.model.ShoppingCart;
import edu.mum.cs.cs472wap.lab13.model.ShoppingCartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;

@WebServlet(name = "addShoppingCart", urlPatterns = "/addShoppingCart")
public class AddShoppingCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            Random random = new Random();
            shoppingCart.setId(random.nextLong());
        }
        Integer productId = Integer.valueOf(req.getParameter("addButton"));
        Integer productQuantity = Integer.valueOf(req.getParameter("quantity"));
        Optional<ShoppingCartItem> itemSearchInList = shoppingCart.getItems().stream()
                .filter(x -> x.getProduct().getId() == productId).findAny();
        if (itemSearchInList.isPresent()) {
            shoppingCart.getItems().forEach(x -> {
                if (x.getId() == itemSearchInList.get().getId()) {
                    x.setQuantity(x.getQuantity() + productQuantity);
                    return;
                }
            });
        } else {
            ShoppingCartItem item = new ShoppingCartItem(shoppingCart.getItems().size() + 1,
                    DataBase.produtcs.get(productId),
                    productQuantity,
                    shoppingCart);
            shoppingCart.getItems().add(item);
        }
        session.setAttribute("shoppingCart", shoppingCart);
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
