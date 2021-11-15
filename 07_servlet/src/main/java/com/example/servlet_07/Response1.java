package com.example.servlet_07; /**
 * @Description
 * @author candk
 * @version
 * @date 9/27/21 - 9:13 PM
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Response1 responses.");
        response.setStatus(302);
        response.setHeader("Location", "http://localhost:8088/07_servlet/response2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
