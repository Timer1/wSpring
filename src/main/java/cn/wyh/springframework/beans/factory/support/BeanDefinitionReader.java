package cn.wyh.springframework.beans.factory.support;


import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.core.io.Resource;
import cn.wyh.springframework.core.io.ResourceLoader;

import java.beans.Beans;

public interface BeanDefinitionReader {
    /**
     * 获取bean注册器
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取resource加载器
     * @return
     */
    ResourceLoader getResourceLoader();

    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinition(Resource... resources) throws BeansException;

    void loadBeanDefinition(String resources) throws BeansException;


}
