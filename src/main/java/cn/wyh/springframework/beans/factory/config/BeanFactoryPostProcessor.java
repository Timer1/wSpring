package cn.wyh.springframework.beans.factory.config;

import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    /**
     * beanDefinition注册到bean工厂后，对其中的beanDefinition进行处理
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
