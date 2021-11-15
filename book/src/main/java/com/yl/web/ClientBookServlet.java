package com.yl.web;

import com.yl.pojo.Book;
import com.yl.pojo.Page;
import com.yl.service.impl.BookService;
import com.yl.service.impl.BookServiceImpl;
import com.yl.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author candk
 * @Description
 * @date 11/1/21 - 2:52 PM
 */
public class ClientBookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();


    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNum, pageSize);
        page.setUrl("client/clientBookServlet?action=page");


        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), 10000);

        Page<Book> page = bookService.pageByPrice(pageNum, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice");

        if (request.getParameter("min") != null) {
            sb.append("&min=" + request.getParameter("min"));
        }

        if (request.getParameter("max") != null) {
            sb.append("&max=" + request.getParameter("max"));
        }

        page.setUrl(sb.toString());

        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
