package cn.bugstack.springframework.utils;

import cn.bugstack.springframework.beans.BeansException;

public class ClassUtils {
    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try{
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Exception e){
            throw new BeansException("Cannot access thread context ClassLoader");
        }
        if (cl == null){
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
