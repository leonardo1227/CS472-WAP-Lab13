package edu.mum.cs.cs472wap.lab13.controller;

import edu.mum.cs.cs472wap.lab13.model.ShoppingCart;
import edu.mum.cs.cs472wap.lab13.model.ShoppingCartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "removeShoppingCartController", urlPatterns = "/removeShoppingCart")
public class RemoveShoppingCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        ShoppingCartItem item = new ShoppingCartItem(Integer.valueOf(req.getParameter("removeButton")));
        shoppingCart.setItems(shoppingCart.getItems().stream()
                .filter(x -> x.getId() != item.getId())
                .collect(Collectors.toList()));
        session.setAttribute("shoppingCart", shoppingCart);
        resp.sendRedirect(req.getContextPath() + "/shoppingCart");
    }
}
