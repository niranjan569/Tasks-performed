package com.autoWireExample;

import org.springframework.stereotype.Component;

//declaring bean
@Component
public class License {
	private String pNumber = "123456ABC";

	// method to get number
	public String getPNumber() {
		return pNumber;
	}

	// method to set number
	public void setPNumber(String number) {
		this.pNumber = number;
	}

	@Override
	public String toString() {
		return "License [number=" + pNumber + "]";
	}
}
