package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView display(@RequestParam("id") int identity)
	{
		return new ModelAndView("hellopage","message","Hello spring mvc"+identity);
	}
	
	@RequestMapping("/welcome")
	public String displaywelcome()
	{
		return "welcome";
	}
}
