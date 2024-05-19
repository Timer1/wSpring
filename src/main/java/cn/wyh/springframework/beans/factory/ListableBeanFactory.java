package cn.wyh.springframework.beans.factory;

import cn.wyh.springframework.beans.BeansException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
