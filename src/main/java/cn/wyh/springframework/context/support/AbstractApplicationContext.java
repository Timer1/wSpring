package cn.wyh.springframework.context.support;

import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.factory.BeanFactory;
import cn.wyh.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.wyh.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.wyh.springframework.beans.factory.config.BeanPostProcessor;
import cn.wyh.springframework.context.ConfigurableApplicationContext;
import cn.wyh.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 创建beanFactory，加载beanDefinition
        refreshBeanFactory();
        // 获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        // 执行beanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);
        // 注册beanPostProcessor
        registerBeanPostProcessors(beanFactory);
        // 加载单例bean
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor: beanFactoryPostProcessorMap.values())
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()){
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> type) throws BeansException {
        return getBeanFactory().getBean(beanName, type);
    }
}