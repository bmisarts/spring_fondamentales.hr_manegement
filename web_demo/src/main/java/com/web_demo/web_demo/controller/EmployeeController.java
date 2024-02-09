package com.web_demo.web_demo.controller;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web_demo.web_demo.model.Employee;
import com.web_demo.web_demo.service.EmployeeService;

import org.springframework.ui.Model;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Employee> listEmployee = service.getEmployees();
        model.addAttribute("employees", listEmployee);
        
        return "home";
    }
    
    @GetMapping("/createEmployee")
	public String createEmployee(Model model) {
		Employee e = new Employee();
		model.addAttribute("employee", e);
		return "createEmployee";
	}

	
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable("id") final int id, Model model) {
		Employee e = service.getEmployee(id);		
		model.addAttribute("employee", e);	
		return "updateEmployee";		
	}
    
    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return new ModelAndView("redirect:/");
    }
    
    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
        service.deleteEmployee(id);
        return new ModelAndView("redirect:/");
    }
	
}