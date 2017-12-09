package mc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.model.User;
import mc.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
    private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String username,String password) {
		User user = userService.findByUserNameAndPwd(username, password);
		if(null == user) {
            model.addAttribute("error", "Your username and password is invalid.");
			return "login";
		}else {
			
			return "redirect:/patientHome?uid="+user.getId();
		}
    }
	
	@GetMapping("/regPage")
	public String home(HttpServletRequest request){
		return "reg";
	}

}
