package com.abasjr.abasweb.plugin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

// 15 Extentions Point  
// Memanipulasi objek Bean (bisa membuat semacam extentions atau plugin)
// Disini akan me log ketika sebuah Bean di create
@Component
public class LogPlugin extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // return super.postProcessAfterInitialization(bean, beanName);
        System.out.println("Telah dibuat bean dengan nama " + beanName + " dengan type " + bean.getClass().getName());
        return bean;
    }
}