package cn.wyh.springframework.beans.factory;

import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;

    <T> T getBean(String beanName, Class<T> type) throws BeansException;

}
