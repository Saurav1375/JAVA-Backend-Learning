package org.example.servlet;

import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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
            }
        }

        PrintWriter out = res.getWriter();
        out.println("Welcome " + user);
    }
}
