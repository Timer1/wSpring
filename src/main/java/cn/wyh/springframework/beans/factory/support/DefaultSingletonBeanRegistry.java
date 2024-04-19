package cn.wyh.springframework.beans.factory.support;

import cn.wyh.springframework.beans.factory.config.BeanDefinition;
import cn.wyh.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonBeanMap = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    // 继承此类的类才可以调用该方法
    protected void addSingleton(String beanName, Object singletonObject){
        singletonBeanMap.put(beanName, singletonObject);
    }
}
