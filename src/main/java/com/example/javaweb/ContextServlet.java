package com.example.javaweb; /**
 * @Description
 * @author candk
 * @version
 * @date 9/27/21 - 2:06 PM
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 *
 */

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        String username = context.getInitParameter("username");
        System.out.println(username);
        String password = context.getInitParameter("password");
        System.out.println(password);
        String contextPath = context.getContextPath();
        System.out.println(contextPath);
        String realPath = context.getRealPath("/");
        System.out.println(realPath);

        context.setAttribute("key1", "value1");
        System.out.println(context.getAttribute("key1"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
