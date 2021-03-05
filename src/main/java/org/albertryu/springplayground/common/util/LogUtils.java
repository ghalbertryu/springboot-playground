package org.albertryu.springplayground.common.util;

public class LogUtils {

    public static String buildClassTag(Object obj) {
        String className = obj.getClass().getSimpleName();
        return "[" + className + "]";
    }
}
