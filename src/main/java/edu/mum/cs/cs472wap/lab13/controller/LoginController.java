package edu.mum.cs.cs472wap.lab13.controller;

import edu.mum.cs.cs472wap.lab13.database.DataBase;
import edu.mum.cs.cs472wap.lab13.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/page/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = DataBase.users.get(req.getParameter("username"));
        if(user!=null && user.getPassword().equals(req.getParameter("password"))){
            HttpSession session = req.getSession();
            session.setAttribute("userLogged",user);
            //RequestDispatcher dispatcher = req.getRequestDispatcher("/products");
            //dispatcher.forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/products");
        }else{
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }
}
