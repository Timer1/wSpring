package cn.wyh.springframework.beans.factory.support;

import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.factory.BeanFactory;
import cn.wyh.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;
import cn.wyh.springframework.beans.factory.config.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableListableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> type) throws BeansException {
        return (T) getBean(beanName);
    }

    protected <T> T doGetBean(final String beanName, final Object... args){
        Object bean = getSingleton(beanName);
        if (bean != null){
            System.out.println("从缓存中获取单例对象");
            return (T)bean;
        }

        System.out.println("缓存不存在，获取beanDefinition进行实例化");
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object... args);

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }
}
