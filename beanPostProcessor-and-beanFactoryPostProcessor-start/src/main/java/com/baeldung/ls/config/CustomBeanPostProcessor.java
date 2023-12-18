package com.baeldung.ls.config;

import com.baeldung.ls.persistence.model.BeanA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor, Ordered {

    private static final Logger LOG = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOG.info("CustomBeanPostProcessor is invoked for before initializing bean: {}", beanName);
        if("beanA".equals(beanName)){
            BeanA ba = (BeanA) bean;
            LOG.info("Before initialising the bean ba.getFoo: {}", ba.getFoo());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOG.info("CustomBeanPostProcessor is invoked for after initializing bean: {}", beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}