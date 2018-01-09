package com.annotation;

public class Person {
	private String pName;
	private int pAge;
	
	public String getpName() {
		return pName;
	}
	public void setpName(String name) {
		this.pName = name;
	}
	public int getpAge() {
		return pAge;
	}
	public void setpAge(int age) {
		this.pAge = age;
	}
	
	@Override
	public String toString() {
		return "Person [pName=" + pName + ", pAge=" + pAge + "]";
	}
	
}
