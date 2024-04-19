package cn.wyh.springframework.beans.factory.support;

import cn.wyh.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
