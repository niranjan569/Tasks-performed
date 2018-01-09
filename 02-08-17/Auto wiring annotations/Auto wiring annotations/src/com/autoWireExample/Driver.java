package com.autoWireExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//declaring bean with name
@Component("driver")
public class Driver {

	private License pLicense;

	// injecting license using setter
	@Autowired
	// method to set license
	public void setPLicense(License license) {
		this.pLicense = license;
	}

	// method to get license
	public License getPLicense() {
		return pLicense;
	}

	@Override
	public String toString() {
		return "Driver [license=" + pLicense + "]";
	}
}
