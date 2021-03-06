package com.yl.web; /**
 * @Description
 * @author candk
 * @version
 * @date 10/21/21 - 4:06 PM
 */

import com.google.gson.Gson;
import com.yl.pojo.User;
import com.yl.service.impl.UserService;
import com.yl.service.impl.UserServiceImpl;
import com.yl.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();



    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");



        User loginUser = userService.login(new User(null, username, password, null));

        if (loginUser == null) {
            request.setAttribute("username", username);
            request.setAttribute("msg", "username or password error!");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("user", loginUser);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect(request.getContextPath());
    }

    protected void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername", existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        response.getWriter().write(json);
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        String codeToken = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());

        if (codeToken != null && codeToken.equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                request.setAttribute("msg", "??????????????????");
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                userService.registUser(user);
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "??????????????????");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
}
