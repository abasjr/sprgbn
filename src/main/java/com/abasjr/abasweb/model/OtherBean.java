package com.abasjr.abasweb.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// 08 Dependency Injection 3
// public class OtherBean {

// 14 Aware (ApplicationContextAware)
public class OtherBean implements ApplicationContextAware {

    private DataBean dataBean;
    private SampleBean simpleBean;

    private ApplicationContext context;

    public OtherBean(DataBean dataBean, SampleBean simpleBean) {
        this.dataBean = dataBean;
        this.simpleBean = simpleBean;
    }

    public DataBean getDataBean() {
        return this.dataBean;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public SampleBean getSimpleBean() {
        return this.simpleBean;
    }

    public void setSimpleBean(SampleBean simpleBean) {
        this.simpleBean = simpleBean;
    }

    // 14 Aware

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void doSomething(){
        if (context!=null) {
            System.out.println("CONTEXT ADA");
        } else {
            System.out.println("CONTEXT TIDAK ADA");
        }
    }
    
}