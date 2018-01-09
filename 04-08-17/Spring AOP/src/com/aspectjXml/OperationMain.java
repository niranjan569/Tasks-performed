package com.aspectjXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OperationMain {

	public static void main(String[] args) {

		// Configuring application context
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		// Getting bean from context
		Operation operation = (Operation) context.getBean("operation");
		// invoking methods of operation class
		operation.msg();
		operation.m();
		operation.k();
		operation.display();
		try {
			operation.validate(19);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
