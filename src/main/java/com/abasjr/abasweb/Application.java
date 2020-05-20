package com.abasjr.abasweb;

import com.abasjr.abasweb.model.DataBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// 04 Container
		ApplicationContext context = SpringApplication.run(Configuration.class, args); 
		//Application.class sebuah class configuration sebagai konfigurasi spring

		// 05 Bean
		DataBean data = context.getBean(DataBean.class);
		System.out.println(data.getValue());
	}

}
