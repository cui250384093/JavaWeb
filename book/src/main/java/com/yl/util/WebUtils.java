package com.yl.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author candk
 * @Description
 * @date 10/22/21 - 2:41 PM
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map map, T bean) {

        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static int parseInt(String strInt, int defaultValue) {
        if (strInt != null) {
            return Integer.parseInt(strInt);
        }

        return defaultValue;
    }
}
