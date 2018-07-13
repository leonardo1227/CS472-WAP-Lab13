package edu.mum.cs.cs472wap.lab13.controller;

import edu.mum.cs.cs472wap.lab13.database.DataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/products", name = "productsController")
public class ProductsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        session.setAttribute("productList", DataBase.produtcs);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/page/products.jsp");
        dispatcher.forward(req, resp);
    }
}
