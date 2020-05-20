package com.abasjr.abasweb;

import com.abasjr.abasweb.model.DataBean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Configuration {
    
    // 05 Bean
    // Bean adalah sebuah object, ketika kita membuat bean, maka kita membuat sebuah object
    
    @Bean // untuk menandai bahwa metode ini adalah sebuah bean
    public DataBean createDataBean(){
        DataBean bean = new DataBean("Abas Junior");
        return bean;
    }
}