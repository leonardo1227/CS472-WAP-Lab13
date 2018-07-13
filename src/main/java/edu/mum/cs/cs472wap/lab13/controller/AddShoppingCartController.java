package edu.mum.cs.cs472wap.lab13.controller;

import edu.mum.cs.cs472wap.lab13.database.DataBase;
import edu.mum.cs.cs472wap.lab13.model.ShoppingCart;
import edu.mum.cs.cs472wap.lab13.model.ShoppingCartItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addShoppingCart", urlPatterns = "/addShoppingCart")
public class AddShoppingCartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        if(shoppingCart==null){
            shoppingCart = new ShoppingCart();
            //shoppingCart.setId(Integer.parseInt(session.getId()));
        }
        Integer productId = Integer.valueOf(req.getParameter("addButton"));
        Integer productQuantity = Integer.valueOf(req.getParameter("quantity"));
        ShoppingCartItem item = new ShoppingCartItem(shoppingCart.getItems().size()+1,
                DataBase.produtcs.get(productId),
                productQuantity,
                shoppingCart);
        shoppingCart.getItems().add(item);
        shoppingCart.setTotalPrice(shoppingCart.getItems().stream()
                .map(x -> x.getTotalPrice())
                .reduce(0.0,Double::sum));
        session.setAttribute("shoppingCart",shoppingCart);

        resp.sendRedirect(req.getContextPath()+"/products");

    }
}
