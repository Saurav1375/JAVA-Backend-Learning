package org.example.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/gt")
public class NewServlet  extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //using req dispatcher
//        String user = (String) req.getAttribute("g");

        //using url rewriting
//        String user = req.getParameter("name");

        //using session
//        HttpSession session = req.getSession();
//        String user = session.getAttribute("name").toString();

        //using cookie
        String user = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) {
                user = cookie.getValue();
                break;
            }
        }

        PrintWriter out = res.getWriter();
        out.println("Welcome " + user);

        //servlet context
        ServletContext context = getServletContext();
        String phone = context.getInitParameter("Phone");
        out.println(phone);
    }
}
