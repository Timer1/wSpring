package cn.wyh.springframework.context.support;

import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.factory.support.DefaultListableBeanFactory;

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {

    }
}
