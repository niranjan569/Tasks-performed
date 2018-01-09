package com.autoWireExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

	public static void main(String args[]) {
		// load configuration class
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// get instance of bean
		Driver driver = (Driver) context.getBean("driver");
		System.out.println("Driver Details : " + driver);
	}

}
