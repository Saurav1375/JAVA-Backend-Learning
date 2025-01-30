package org.example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/greet")
public class GreetServlet  extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String name = req.getParameter("name");
//        PrintWriter out = res.getWriter();
//        out.println("Hello, " + name + "!");

        //using Sessions
//        HttpSession session = req.getSession();
//        session.setAttribute("name", name);
//        res.sendRedirect("gt");


        //using cookie
        Cookie ck = new Cookie("name", name);
        res.addCookie(ck);
        res.sendRedirect("gt");

        //using URL rewriting
//        res.sendRedirect("gt?name=" + name);


        //using Request Dispatcher
//        req.setAttribute("g", "Hello, " + name + "!");
//        RequestDispatcher rd = req.getRequestDispatcher("gt");
//        rd.forward(req, res);
    }
}
