package com.yl.filter;

import com.yl.util.JdbcUtils;

import javax.servlet.*;

/**
 * @author candk
 * @Description
 * @date 11/15/21 - 11:10 AM
 */
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {

        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
