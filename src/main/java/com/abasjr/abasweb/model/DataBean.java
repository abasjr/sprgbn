package com.abasjr.abasweb.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 05 Bean
public class DataBean {

    private String value;

    public DataBean(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // 13 Lifecycle
    @PostConstruct
    public void init(){
        System.out.println("INITIAL DATABEAN " + value);
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("DESTROY DATABEAN " + value); // kalau Scope prototype dia ga bakal di destroy, kecuali kalau default "Singleton"
    }
}