package com.employee.controller;

import java.util.List;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;
	
	// method to handle /add request with get method
	// return's addemployee view
	@RequestMapping(value = "/add",method=RequestMethod.GET)
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("employee",new Employee());
		return "addemployee";
	}
	
	// method to handle /add request with post method
	// return's addemployee view
	// saves employee details
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee,BindingResult result)
	{
		
		if (!result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("addemployee","msg", "Added Sucessfully...");
			dao.saveEmployee(employee);
			return modelAndView;
		}
		return new ModelAndView("addemployee","msg", "Error");
	}
	
	// method to handle /view request
	// get's list of employees and retur's viewemployees view
	@RequestMapping(value="/view")
	public ModelAndView viewEmployees(){
		List emplist = dao.getAllEmployees();
		return new ModelAndView("viewemployees","emplist",emplist);
	}
	
	// method to handle /delete request
	// redirects to /view request  
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam int id)
	{
		dao.delete(id);
		return "redirect:/view";
	}
	
	// method to handle /edit request
	// get employee details by id and passes it to editemployee view
	@RequestMapping(value="/edit")
	public ModelAndView editEmployee(@RequestParam int id)
	{
		Employee employee = dao.getById(id);
		return new ModelAndView("editemployee", "employee", employee);
	}
	
	// method to handle /update request
	//redirecs to /view request
	@RequestMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee,BindingResult result)
	{
		dao.saveEmployee(employee);
		return "redirect:/view";
	}
}
