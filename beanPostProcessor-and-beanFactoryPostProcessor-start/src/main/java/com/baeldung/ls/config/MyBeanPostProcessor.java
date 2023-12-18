package com.baeldung.ls.config;

import com.baeldung.ls.persistence.model.BeanA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    private static final Logger LOG = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOG.info("Before initialising the bean: {}", beanName);
        if("beanA".equals(beanName)){
            BeanA ba = (BeanA) bean;
            LOG.info("Before initialising the bean ba.getFoo: {}", ba.getFoo());
            ba.setFoo("bar2");
            LOG.info("Before initialising the bean ba.getFoo: {}", ba.getFoo());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOG.info("After initialising the bean: {}", beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
