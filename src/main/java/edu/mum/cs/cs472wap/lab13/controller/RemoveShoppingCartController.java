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

@WebServlet(name = "removeShoppingCartController", urlPatterns = "/removeShoppingCart")
public class RemoveShoppingCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        ShoppingCartItem item = new ShoppingCartItem(Integer.valueOf(req.getParameter("removeButton")));
        for(ShoppingCartItem i:shoppingCart.getItems()){
            if(i.getId()==item.getId()){
                item = i;
            }
        }
        shoppingCart.getItems().remove(item);
        shoppingCart.setTotalPrice(shoppingCart.getItems().stream()
                .map(x -> x.getTotalPrice())
                .reduce(0.0,Double::sum));
        session.setAttribute("shoppingCart",shoppingCart);

        resp.sendRedirect(req.getContextPath()+"/shoppingCart");
    }
}
