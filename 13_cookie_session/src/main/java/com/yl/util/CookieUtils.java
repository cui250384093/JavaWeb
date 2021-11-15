package com.yl.util;

import javax.servlet.http.Cookie;

/**
 * @author candk
 * @Description
 * @date 11/2/21 - 4:18 PM
 */
public class CookieUtils {

    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }
}
