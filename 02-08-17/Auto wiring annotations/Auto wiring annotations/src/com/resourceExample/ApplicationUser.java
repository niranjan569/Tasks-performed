package com.resourceExample;

import org.springframework.stereotype.Component;

//declaring bean
@Component
public class ApplicationUser {

	// Private variable for name
	private String pName;

	// method to get name
	public String getpName() {
		return pName;
	}

	// method to set name
	public void setpName(String name) {
		this.pName = name;
	}

	@Override
	public String toString() {
		return "ApplicationUser [Name=" + pName + "]";
	}

}
