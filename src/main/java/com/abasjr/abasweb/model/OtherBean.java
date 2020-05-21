package com.abasjr.abasweb.model;

// 08 Dependency Injection 3
public class OtherBean {
    
    private DataBean dataBean;
    private SampleBean simpleBean;

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
    
}