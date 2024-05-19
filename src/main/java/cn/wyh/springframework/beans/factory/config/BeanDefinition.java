package cn.wyh.springframework.beans.factory.config;

import cn.wyh.springframework.beans.PropertyValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BeanDefinition {

    private Class beanClazz;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClazz){
        this.beanClazz = beanClazz;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClazz, PropertyValues propertyValues){
        this.beanClazz = beanClazz;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }
}
