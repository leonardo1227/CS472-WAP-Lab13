package edu.mum.cs.cs472wap.lab13.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter",
            urlPatterns = {"/checkout","/confirmationCheckout"})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();


        if(session!=null && session.getAttribute("userLogged")!=null){
            filterChain.doFilter(request,response);
        }else{
            session.setAttribute("filtredUrl",request.getRequestURL().toString());
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }

    @Override
    public void destroy() {

    }
}
