package com.abasjr.abasweb;


import com.abasjr.abasweb.model.DataBean;
import com.abasjr.abasweb.model.SampleBean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class Configuration {
    
    // 05 Bean
    // Bean adalah sebuah object, ketika kita membuat bean, maka kita membuat sebuah object
    
    // @Bean // untuk menandai bahwa metode ini adalah sebuah bean
    // @Primary
    @Bean(name = "Abas")
    public DataBean createDataBean(){
        DataBean bean = new DataBean("Abas Junior");
        return bean;
    }
    
    // 07 Depedency Injection 2
    // @Bean
    @Bean(name = "Sans")
    @Primary
    public DataBean createDataBean2(){
        DataBean bean = new DataBean("Santos");
        return bean;
    }

    // 06 Dependency Injection
    // dengan kita menambah parameter dlm methodnya, spring akan otomatis mendeteksi value apa yang harus di inject 
    // maka dia akan mencari dataBean di dalam container
    @Bean
    public SampleBean createSampleBean(@Qualifier("Abas") DataBean dataBean){ // Abas Junior
        SampleBean bean = new SampleBean(dataBean);
        return bean;
    }
}