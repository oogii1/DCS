package mc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.model.Doctor;
import mc.model.User;
import mc.service.DoctorService;
import mc.service.UserService;

@Controller
public class LoginController {
	
	private HttpSession session;
	
	@Autowired
    private UserService userService;
	@Autowired
    private DoctorService doctorService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String username,String password, HttpServletRequest request) {
		session = request.getSession();
		User user = userService.findByUserNameAndPwd(username, password);
		if(null == user) {
            model.addAttribute("error", "Your username and password is invalid.");
			return "login";
		}else {

			System.out.println(user.getSetting().getVarValue());
			
			if(user.getSetting().getVarValue().equals("Patient")) {
				session.setAttribute("patient", user);
				session.setAttribute("type", "patient");
				return "redirect:/patientHome?uid="+user.getId();
			}
				
			if(user.getSetting().getVarValue().equals("Doctor")) {
				Doctor doctor = doctorService.findDoctorByUser(user);
				session.setAttribute("type", "doctor");
				session.setAttribute("doctor", doctor);
				return "doctorHome";//TODO doctor home.jsp
			}
				
			if(user.getSetting().getVarValue().equals("Receptionist")) {
				session.setAttribute("type", "reception");
				session.setAttribute("reception", user);
				return "redirect:receptionHome";
			}
			return "error";

		}
    }
	
	@GetMapping("/regPage")
	public String home(HttpServletRequest request){
		return "reg";
	}

}
	