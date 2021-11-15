package com.example.servlet_07; /**
 * @Description
 * @author candk
 * @version
 * @date 9/27/21 - 8:08 PM
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet2 username: " + request.getParameter("username"));
        System.out.println(request.getAttribute("key"));

        System.out.println("Servlet2 finish.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
