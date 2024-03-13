package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;

public interface BeanPostProcessor {
    // 在Bean初始化之前进行拓展
    Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException;

    // 在Bean初始化之后进行拓展
    Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException;
}
