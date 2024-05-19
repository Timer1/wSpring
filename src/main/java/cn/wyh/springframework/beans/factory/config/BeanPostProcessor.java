package cn.wyh.springframework.beans.factory.config;

import cn.wyh.springframework.beans.BeansException;

public interface BeanPostProcessor {

    /**
     * 在bean被实例化之前，执行此方法
     * @param beanName
     * @param bean
     * @return
     * @throws BeansException
     */
    Object postBeforeInitialization(String beanName, Object bean) throws BeansException;

    /**
     * 在bean被实例化之后，执行此方法
     * @param beanName
     * @param bean
     * @return
     * @throws BeansException
     */
    Object postAfterInitialization(String beanName, Object bean) throws BeansException;
}
