package com.yl.web;

import com.yl.util.CookieUtils;

import javax.servlet.http.*;

/**
 * @author candk
 * @Description
 * @date 11/2/21 - 3:33 PM
 */
public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Cookie cookie = new Cookie("key1", "value1");

        response.addCookie(cookie);

        response.getWriter().write("Cookie created successful.");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            response.getWriter().write("cookie[" + cookie.getName() + "]=" + cookie.getValue() + "<br/>");
        }

    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Cookie cookie = new Cookie("key1", "value2");
        response.addCookie(cookie);

    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);

        response.addCookie(cookie);

    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

    }

    protected void life3600(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60);

        response.addCookie(cookie);

    }

    protected void testPath(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Cookie cookie1 = new Cookie("path1", "path1");
        cookie1.setPath(request.getContextPath() + "/abc");
        Cookie cookie2 = new Cookie("path2", "path2");

        response.addCookie(cookie1);
        response.addCookie(cookie2);

    }
}
