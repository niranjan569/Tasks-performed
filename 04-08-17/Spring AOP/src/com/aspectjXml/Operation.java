package com.aspectjXml;

public class Operation {

	// method with void return type
	public void msg() {
		System.out.println("msg method invoked");
	}

	// method with return type and starts with m
	public int m() {
		System.out.println("m method invoked");
		return 3;
	}

	// method with return type
	public int k() {
		System.out.println("k method invoked");
		return 7;
	}

	public void display() {
		System.out.println("display method");
	}

	// method which throws exception
	public void validate(int age) throws Exception {
		if (age < 18) {
			throw new ArithmeticException("Not valid age");
		} else {
			System.out.println("Thanks for vote");
		}
	}
}
