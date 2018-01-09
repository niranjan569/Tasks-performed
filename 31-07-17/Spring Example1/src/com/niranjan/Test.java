package com.niranjan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// first load xml file
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		// get the instance of bean
		First first = (First) context.getBean("first");

		// invoke the method using instance above
		System.out.println(first.getpMessage());
	}

}
