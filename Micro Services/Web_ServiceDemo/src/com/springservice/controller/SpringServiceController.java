package com.springservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/service/greeting")
public class SpringServiceController {
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public @ResponseBody String getGreeting(@PathVariable String name) {
		String result="Hello "+name;		
		return result;
	}
	
	@RequestMapping(value="/json", method = RequestMethod.POST, headers="Accept=application/json")
	public String returnJson(){
		return "hello";
	}
	
}
