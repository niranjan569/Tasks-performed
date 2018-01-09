package com.resourceExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

	public static void main(String[] args) {

		// Load the cofiguration class
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// get instance of bean
		Application application = (Application) context.getBean("application");
		System.out.println("Application Details : " + application);
	}
}
