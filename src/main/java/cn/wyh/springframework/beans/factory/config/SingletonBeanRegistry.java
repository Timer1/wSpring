package cn.wyh.springframework.beans.factory.config;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
