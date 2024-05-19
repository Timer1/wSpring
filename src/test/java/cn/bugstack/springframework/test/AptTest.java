package cn.bugstack.springframework.test;

import cn.bugstack.springframework.test.bean.UserDao;
import cn.bugstack.springframework.test.bean.UserService;
import cn.hutool.core.io.IoUtil;
import cn.wyh.springframework.beans.PropertyValue;
import cn.wyh.springframework.beans.PropertyValues;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;
import cn.wyh.springframework.beans.factory.BeanFactory;
import cn.wyh.springframework.beans.factory.config.BeanReference;
import cn.wyh.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.wyh.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.wyh.springframework.core.io.DefaultResourceLoader;
import cn.wyh.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class AptTest {

    private DefaultResourceLoader resourceLoader;
    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinition("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


}
