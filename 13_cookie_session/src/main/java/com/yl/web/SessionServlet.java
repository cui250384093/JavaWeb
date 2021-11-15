package com.yl.web;

import javax.servlet.http.*;

/**
 * @Description
 * @author candk
 * @version
 * @date 11/4/21 - 9:25 AM
 */

public class SessionServlet extends BaseServlet {

    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();

        boolean isNew = session.isNew();
        String id = session.getId();

        response.getWriter().write("id = " + id +" <br/>");
        response.getWriter().write("is new ? " + isNew + " <br/>");
        int maxInactiveInterval = session.getMaxInactiveInterval();
        response.getWriter().write("max interval" + maxInactiveInterval);
    }

    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();

        session.setAttribute("key1", "value1");
    }

    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Object attribute = session.getAttribute("key1");
        response.getWriter().write(attribute.toString());
    }

    /**
     * default timeout 1800
     * @param request
     * @param response
     * @throws Exception
     */
    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        int maxInactiveInterval = session.getMaxInactiveInterval();
        response.getWriter().write("max interval" + maxInactiveInterval);

    }

    protected void life3(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();

        session.setMaxInactiveInterval(3);
        response.getWriter().write("max interval" + session.getMaxInactiveInterval());

    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();

        session.invalidate();
    }

}
