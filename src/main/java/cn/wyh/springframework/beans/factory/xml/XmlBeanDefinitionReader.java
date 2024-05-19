package cn.wyh.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.wyh.springframework.beans.BeansException;
import cn.wyh.springframework.beans.PropertyValue;
import cn.wyh.springframework.beans.PropertyValues;
import cn.wyh.springframework.beans.factory.config.BeanDefinition;
import cn.wyh.springframework.beans.factory.config.BeanReference;
import cn.wyh.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.wyh.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.wyh.springframework.core.io.Resource;
import cn.wyh.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public void loadBeanDefinition(Resource resource) throws BeansException {
        try {
            InputStream inputStream = resource.getInputStream();
            doLoadBeanDefinitions(inputStream);
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IO异常，读取resource错误:"+resource,e);
        }
    }

    @Override
    public void loadBeanDefinition(Resource... resources) throws BeansException {
        for (Resource resource : resources){
            loadBeanDefinition(resource);
        }
    }

    @Override
    public void loadBeanDefinition(String resources) throws BeansException {
        Resource resource = getResourceLoader().getResource(resources);
        loadBeanDefinition(resource);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException{
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++){
            // 解析xml
            if (!(childNodes.item(i) instanceof Element)){
                continue;
            }
            if (!("bean".equals(childNodes.item(i).getNodeName()))){
                continue;
            }

            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            Class clazz = Class.forName(className);

            String beanName = StrUtil.isNotEmpty(id)?id : name;
            if (beanName == null){
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 创建beanDefinition
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            for (int j = 0; j < bean.getChildNodes().getLength(); j++){
                if (!(bean.getChildNodes().item(j) instanceof Element)){
                    continue;
                }
                if (!("property".equals(bean.getChildNodes().item(j).getNodeName()))){
                    continue;
                }
                Element property = (Element) bean.getChildNodes().item(j);
                String arrName = property.getAttribute("name");
                String arrValue = property.getAttribute("value");
                String arrRef = property.getAttribute("ref");
                Object value = StrUtil.isNotEmpty(arrRef)? new BeanReference(arrRef) : arrValue;
                PropertyValue propertyValue = new PropertyValue(arrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)){
                throw new BeansException("注册bean信息异常，重复的beanName:"+beanName);
            }
            //注册bean信息
            getRegistry().registryBeanDefinition(beanName, beanDefinition);
        }
    }
}
