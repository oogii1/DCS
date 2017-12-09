package mc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		//request.setAttribute("mode", "MODE_HOME");
		return "homepage";
	}
	
	@GetMapping("/loginPage")
	public String loginPage(HttpServletRequest request){
		//request.setAttribute("mode", "MODE_HOME");
		return "login";
	}
}
