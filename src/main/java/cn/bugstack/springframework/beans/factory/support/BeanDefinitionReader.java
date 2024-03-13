package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.core.io.ResourceLoader;

import java.beans.Beans;

public interface BeanDefinitionReader {
    // 获得Register来注册bean
    BeanDefinitionRegistry getRegistry();

    // 获得loader来加载资源
    ResourceLoader getResourceLoader();

    // 对应三种资源具体加载bean的方法
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
