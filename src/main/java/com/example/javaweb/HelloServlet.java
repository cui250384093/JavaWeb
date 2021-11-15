package com.example.javaweb;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author candk
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;


    @Override
    public void init() {
        message = "Hello World!!!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        ServletConfig servletConfig = getServletConfig();
        String username = servletConfig.getInitParameter("username");
        String url = servletConfig.getInitParameter("url");
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + username + "</h1>");
        out.println("<h1>" + url + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + "post" + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("4");
    }
}