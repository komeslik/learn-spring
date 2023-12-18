package com.baeldung.ls.persistence.model;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanA {
    private String foo;

    private static final Logger LOG = LoggerFactory.getLogger(BeanA.class);

    @PostConstruct
    public void post() {
        LOG.info("value of the property foo is: {}", this.foo);
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
