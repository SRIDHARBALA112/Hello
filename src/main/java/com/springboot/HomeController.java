package com.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String showHome() {
		return "HomePage";
	}
	@GetMapping("/welcome")
	public String showWelcome() {
		return "WelcomePage";
	}
	@GetMapping("/admin")
	public String showadmin() {
		return "AdminPage";
	}
	@GetMapping("/employee")
	public String showEmployee() {
		return "EmployeePage";
	}
	@GetMapping("/student")
	public String showstudent() {
		return "StudentPage";
	}
	@GetMapping("/denied")
	public String showsdenied() {
		return "DeniedPage";
	}

}
