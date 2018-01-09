package com.resourceExample;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

//declaring and naming bean
@Component("application")
public class Application {

	// injecting applicationuser instance by name
	@Resource(name = "applicationUser")
	private ApplicationUser applicationUser;

	@Override
	public String toString() {
		return "Application [ApplicationUser=" + applicationUser + "]";
	}
}
