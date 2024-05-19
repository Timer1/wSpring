package cn.wyh.springframework.beans.factory.support;

import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) {
        System.out.println("jdk实例化");
        Class clazz = beanDefinition.getBeanClazz();

        try {
            if (null != ctor){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("jdk实例化失败 " + clazz.getName(), e);
        }

    }
}
