package cn.wyh.springframework.beans.factory;

import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;
import cn.wyh.springframework.beans.factory.config.BeanPostProcessor;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, HierarchicalBeanFactory{
    BeanDefinition getBeanDefinition(String beanName);

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
