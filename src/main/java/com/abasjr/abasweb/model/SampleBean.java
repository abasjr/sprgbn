package com.abasjr.abasweb.model;

// 06 Depedency Injection

public class SampleBean {
    
    private DataBean dataBean;

    public SampleBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public DataBean getDataBean() {
        return this.dataBean;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }



}