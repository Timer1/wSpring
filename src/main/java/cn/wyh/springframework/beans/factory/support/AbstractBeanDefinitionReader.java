package cn.wyh.springframework.beans.factory.support;

import cn.hutool.extra.validation.BeanValidationResult;
import cn.wyh.springframework.core.io.DefaultResourceLoader;
import cn.wyh.springframework.core.io.ResourceLoader;
import lombok.Data;

import javax.swing.*;

@Data
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private final ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry){
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader){
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
