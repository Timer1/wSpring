package cn.wyh.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.PropertyValue;
import cn.wyh.springframework.beans.PropertyValues;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;
import cn.wyh.springframework.beans.factory.config.BeanReference;
import com.sun.org.apache.bcel.internal.Const;
import lombok.Data;

import java.lang.reflect.Constructor;

@Data
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException {
        Object bean = null;

        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValue(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("实例化bean失败", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 为创建的bean添加属性
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    private void applyPropertyValue(String beanName, Object bean, BeanDefinition beanDefinition) {
        System.out.println("为bean实例添加属性");
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()){
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference){
                    value = getBean(((BeanReference) value).getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        }catch (Exception e){
            throw new BeansException("为bean添加实例时异常:"+beanName);
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object... args){
        System.out.println("创建bean实例");
        Constructor constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClazz();
        for (Constructor ctor : beanClass.getDeclaredConstructors()){
            if (null != args && ctor.getParameterTypes().length == args.length){
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }


}
