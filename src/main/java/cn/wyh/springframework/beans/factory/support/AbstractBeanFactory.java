package cn.wyh.springframework.beans.factory.support;

import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.factory.BeanFactory;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null){
            return bean;
        }

        // 没有object时，先获取beanDefinition，再 将其实例化
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

}
