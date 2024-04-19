package cn.bugstack.springframework.test;

import cn.bugstack.springframework.test.bean.UserService;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;
import cn.wyh.springframework.beans.factory.BeanFactory;
import cn.wyh.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class AptTest {
    @Test
    public void test1(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService_singleton = (UserService)beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }

}
