package com.yl.web;

import com.yl.pojo.*;
import com.yl.service.impl.OrderService;
import com.yl.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @author candk
 * @version
 * @date 11/8/21 - 3:30 PM
 */

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User loginUser = (User) session.getAttribute("user");

        if (loginUser == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }

        Integer userId = loginUser.getId();

        String orderId = orderService.createOrder(cart, userId);

        session.setAttribute("orderId", orderId);

        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Order> orders = orderService.showAllOrders();
        session.setAttribute("orders", orders);

        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);

    }

    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Order> orders = orderService.showMyOrders(userId);
        session.setAttribute("orders", orders);

        request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);

    }

    protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
