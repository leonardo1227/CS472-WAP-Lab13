package edu.mum.cs.cs472wap.lab13.controller;

import edu.mum.cs.cs472wap.lab13.database.DataBase;
import edu.mum.cs.cs472wap.lab13.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "confirmationOrderController", urlPatterns = "/confirmationOrder")
public class ConfirmationOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Order order = new Order();
        order.setUser((User) session.getAttribute("userLogged"));
        order.setShoppingCart((ShoppingCart) session.getAttribute("shoppingCart"));

        Address shippingAddress = new Address(req.getParameter("shippingAddressLine1"),
                req.getParameter("shippingAddressLine2"),
                req.getParameter("shippingCity"),
                req.getParameter("shippingState"),
                req.getParameter("shippingZipcode"));

        Address billingAddress = new Address(req.getParameter("billingAddressLine1"),
                req.getParameter("billingAddressLine2"),
                req.getParameter("billingCity"),
                req.getParameter("billingState"),
                req.getParameter("billingZipcode"));

        Payment payment = new Payment(req.getParameter("cardNumber"),
                req.getParameter("cardDueDate"),
                req.getParameter("cardCVC"),
                req.getParameter("cardHolderName"),
                req.getParameter("cardType"));


        order.setShippingAddress(shippingAddress);
        order.setBillingAddress(billingAddress);
        order.setPayment(payment);
        DataBase.orders.add(order);
        session.setAttribute("order",order);
        session.removeAttribute("shoppingCart");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/page/confirmationOrder.jsp");
        dispatcher.forward(req,resp);
    }
}
