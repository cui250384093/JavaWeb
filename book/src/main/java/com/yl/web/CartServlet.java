package com.yl.web;

import com.yl.pojo.*;
import com.yl.service.impl.BookService;
import com.yl.service.impl.BookServiceImpl;
import com.yl.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Description
 * @author candk
 * @version
 * @date 11/4/21 - 2:36 PM
 */

public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);

        CartItem bookItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        cart.addItem(bookItem);
        request.getSession().setAttribute("cart", cart);

        request.getSession().setAttribute("lastItemName", bookItem.getName());
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null) {
            cart.deleteItem(id);
        }

        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * clear cart
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        cart.clear();

        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart != null) {
            cart.updateItemCount(id, count);
        }

        response.sendRedirect(request.getHeader("Referer"));
    }
}
