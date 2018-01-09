package com.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test {

	public static void main(String[] args) {
		// first load xml file
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		// get the instance of bean
		Customer cus = (Customer) context.getBean("customer");

		// invoke the method using instance above
		cus.displayPerson();
	}

}
