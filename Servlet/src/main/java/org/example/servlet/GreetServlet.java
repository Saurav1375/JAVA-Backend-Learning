package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GreetServlet  extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        PrintWriter out = res.getWriter();
        out.println("Hello, " + name + "!");
    }
}
