package cn.bugstack.springframework.test;

import cn.bugstack.springframework.test.bean.UserService;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;
import cn.wyh.springframework.beans.factory.BeanFactory;
import org.junit.Test;

public class AptTest {
    @Test
    public void test1(){
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(new UserService()));

        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
