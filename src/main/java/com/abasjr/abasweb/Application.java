package com.abasjr.abasweb;

import java.io.IOException;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import com.abasjr.abasweb.model.Author;
import com.abasjr.abasweb.model.DataBean;
import com.abasjr.abasweb.model.FileBean;
import com.abasjr.abasweb.model.OtherBean;
import com.abasjr.abasweb.model.SampleBean;
import com.abasjr.abasweb.model.SayHello;
import com.abasjr.abasweb.model.SayMorning;
import com.abasjr.abasweb.model.User;
import com.abasjr.abasweb.service.DatabaseConfig;
import com.abasjr.abasweb.service.UserService;
import com.abasjr.abasweb.validation.AuthorValidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		// 16 Profile
		System.setProperty("spring.profiles.active", "development"); // ACTIVE_PROFILES_PROPERTY_NAME = "spring.profiles.active"
		// ABSTRACTENVIRONTMENT.class 
		// kalau ada 2 profile separate comma aja (-Dspring.profile.active = "profile1", "profile2")

		// 04 Container
		ApplicationContext context = SpringApplication.run(Configuration.class, args);
		// Application.class sebuah class configuration sebagai konfigurasi spring

		// 16 Profile
		DatabaseConfig config = context.getBean(DatabaseConfig.class);
		System.out.println(config.getValue());

		// 05 Bean
		DataBean data = context.getBean(DataBean.class);
		System.out.println(data.getValue()); // Santos

		// 06 Depedency Injection
		SampleBean dataSample = context.getBean(SampleBean.class);
		System.out.println(dataSample.getDataBean().getValue()); // Abas Junior

		// 08 Dependency Injection 3
		OtherBean dataOther = context.getBean(OtherBean.class);
		System.out.println(dataOther.getDataBean().getValue()); // Santos

		System.out.println(dataOther.getSimpleBean().getDataBean().getValue());

		// 10 Component
		SayHello dataHello = context.getBean(SayHello.class); // walaupun tidak ada diconfiguration tapi tetep ada Beannya karena pakai @Component
		System.out.println(dataHello.hello("Anggit"));

		// 12 Scope
		// Spring secara default akan membuat Bean itu SINGLETON (membuat 1 buah Bean walaupun lebih dari 1x)
		// Singleton, dia akan membuat object yang sama, walaupun dibedakan
		DataBean abas1 = context.getBean(DataBean.class);
		System.out.println(abas1); // Santos DataBean@25fdacb7
		abas1.setValue("Coba dirubah");

		DataBean abas2 = context.getBean(DataBean.class);
		System.out.println(abas2); // Santos DataBean@25fdacb7

		DataBean abas3 = context.getBean(DataBean.class);
		System.out.println(abas3.getValue()); // Santos

		DataBean abas4 = context.getBean(DataBean.class);
		System.out.println(abas4.getValue()); // Santos

		// 14 Aware
		OtherBean dataOther2 = context.getBean(OtherBean.class);
		dataOther2.doSomething(); // CONTEXT ADA

		// 17 Internationalization
		SayMorning dataMorning = context.getBean(SayMorning.class);
		System.out.println(dataMorning.morning("Neymar"));

		// 18 Resources Loader
		FileBean dataFile = context.getBean(FileBean.class);
		try {
			dataFile.printInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 19 Property Source
		Author dataAuthor = context.getBean(Author.class);
		System.out.println(dataAuthor.getName());
		System.out.println(dataAuthor.getEmail());

		// 20 Spring Validator
		Author dataAuthor2 = new Author("","");
		// kalau nanti pakai Spring MVC akan otomatis dilakukan, tidak secara manual
		// untuk sekarang, karena hanya menggunakan Spring Framework, maka kita butuh testing secara manual
		// untuk test manual kita pakai bantuan DataBinder
		DataBinder binder = new DataBinder(dataAuthor2);
		binder.addValidators(new AuthorValidator());

		binder.validate();

		// unntuk mengambil hasil dari validasinya
		BindingResult result =  binder.getBindingResult();

		if (result.hasErrors()) {
			// error
			result.getAllErrors().stream().forEach((error) -> System.out.println(error.getCode())) ; // author.name.black dan author.email.blank (belum diconvert ke message)
		} else {
			// tidak ada error
			System.out.println("Tidak ada error");
		}

		// untuk convert ke message
		MessageSource messageSource = context.getBean(MessageSource.class);
		if (result.hasErrors()) {
			// error
			result.getAllErrors().stream().forEach((error) -> {
				String message = messageSource.getMessage(error.getCode(), null, Locale.getDefault()); // Authot name must be not blank!
				System.out.println(message) ;
			});
		} else {
			// tidak ada error
			System.out.println("Tidak ada error");
		}


		// 21 Bean Validator (Validasi Manual)
		Validator validator = context.getBean(Validator.class);
		User dataUser = new User();
		dataUser.setId("123");
		dataUser.setUsername("");
		dataUser.setEmail("emailsalah");

		Set<ConstraintViolation<User>> validatorResult = validator.validate(dataUser);

		validatorResult.forEach((constraint) -> {
			System.out.println(constraint.getMessage());
		});		
		
		
		// 21 Bean Validator (Validasi Automatic)
		// Validator validator = context.getBean(Validator.class);
		User dataUser2 = new User();
		dataUser.setId("12");
		dataUser.setUsername("");
		dataUser.setEmail("emailsalah2");

		// Set<ConstraintViolation<User>> validatorResult = validator.validate(dataUser);

		// validatorResult.forEach((constraint) -> {
		// 	System.out.println(constraint.getMessage());
		// });

		UserService dataService = context.getBean(UserService.class);
		System.out.println("21 Bean Validator STEP 2 ============");
		// dataService.save(dataUser2); // dipindahkan ke try catch

		// Pakai Try Catch biar tetep running Springnya
		try {
			dataService.save(dataUser2); // harusnya disini Spring melakukan validasi
		} catch (ConstraintViolationException e) {
			e.getConstraintViolations().stream().forEach((error) -> System.out.println(error.getMessage()));
		}

		// try catch getById
		try {
			dataService.getById(""); // harusnya disini Spring melakukan validasi
		} catch (ConstraintViolationException e) {
			e.getConstraintViolations().stream().forEach((error) -> System.out.println(error.getMessage()));
		}

	}

}
