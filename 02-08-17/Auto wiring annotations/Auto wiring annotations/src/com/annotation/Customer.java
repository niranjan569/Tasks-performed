package com.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer {
	@Autowired
	@Qualifier("person1")
	private Person pPerson1;
	
	@Autowired
	@Qualifier("person")
	private Person pPerson;
	
	//method to dispaly person
	public void displayPerson()
	{
		System.out.println(pPerson+" "+pPerson1);
	}
}
