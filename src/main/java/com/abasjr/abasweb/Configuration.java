package com.abasjr.abasweb;

import com.abasjr.abasweb.model.DataBean;
import com.abasjr.abasweb.model.OtherBean;
import com.abasjr.abasweb.model.SampleBean;
// import com.abasjr.abasweb.model.SayHello;
import com.abasjr.abasweb.service.DatabaseConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;

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
    @Primary // Untuk di course, berbeda, sekarang harus di define Primarynya, kalau engga tetep dideteksi error
    // 12 Scope
    @Scope("prototype")   // @Scope("singletone") //defaultnya singleton, bisa di ganti prototype
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

    // 08 Dependency Injection 3
    // Other Bean membutuhkan dependency dari SampleBean dan juga DataBean Santos
    @Bean
    public OtherBean createOtherBean(DataBean dataBean, SampleBean sampleBean){
        OtherBean bean = new OtherBean(dataBean, sampleBean);
        return bean;
    }

    // 10 Component
    // dibuat manual, tanpa @Component
    // @Bean
    // public SayHello createSayHello(){
    //     return new SayHello();
    // }


    // 16 Profile
    // kalau gak di eksekusi keduanya, yg di ekseksi "default" dengan nama "default", makanya profilenya di set
    @Bean(name = "development")
    @Primary 
    public DatabaseConfig createDevDatabaseConfig(){
        return new DatabaseConfig("Database Development");
    }

    @Bean(name = "production")
    public DatabaseConfig createProdDatabaseConfig(){
        return new DatabaseConfig("Database Production");
    }

    // 17 Internationalization
    // multi bahasa, seperti i18n di ruby
    @Bean(name = "messageSource")
    public MessageSource createMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages.morning"); // masukin Package nya dulu, baru filenya, terus itu udah otomatis include semua versi Locale language
        return messageSource;
    }
}