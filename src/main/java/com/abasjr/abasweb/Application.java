package com.abasjr.abasweb;

import com.abasjr.abasweb.model.DataBean;
import com.abasjr.abasweb.model.OtherBean;
import com.abasjr.abasweb.model.SampleBean;
import com.abasjr.abasweb.model.SayHello;

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
		System.out.println(data.getValue()); //Santos

		// 06 Depedency Injection 
		SampleBean dataSample = context.getBean(SampleBean.class);
		System.out.println(dataSample.getDataBean().getValue()); // Abas Junior

		// 08 Dependency Injection 3
		OtherBean dataOther = context.getBean(OtherBean.class);
		System.out.println(dataOther.getDataBean().getValue()); // Santos

		System.out.println(dataOther.getSimpleBean().getDataBean().getValue());

		// 10 Component
		SayHello dataHello = context.getBean(SayHello.class); // walaupun tidak ada diconfiguration tapi tetep ada Bean nya karena pakai @Component 
		System.out.println(dataHello.hello("Anggit"));

		// 12 Scope
		// Spring secara default akan membuat Bean itu SINGLETON (membuat 1 buah Bean walaupun lebih dari 1x)
		// Singleton, dia akan membuat object yang sama, walaupun dibedakan
		DataBean abas1= context.getBean(DataBean.class);
		System.out.println(abas1); //Santos DataBean@25fdacb7
		abas1.setValue("Coba dirubah");

		DataBean abas2= context.getBean(DataBean.class);
		System.out.println(abas2); //Santos DataBean@25fdacb7

		DataBean abas3= context.getBean(DataBean.class);
		System.out.println(abas3.getValue()); //Santos

		DataBean abas4= context.getBean(DataBean.class);
		System.out.println(abas4.getValue()); //Santos
	}

}
