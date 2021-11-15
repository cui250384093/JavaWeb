package com.example.servlet_07; /**
 * @Description
 * @author candk
 * @version
 * @date 9/27/21 - 6:24 PM
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getHeader("User-Agent"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
