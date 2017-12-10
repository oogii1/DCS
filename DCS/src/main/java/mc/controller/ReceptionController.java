package mc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.service.DoctorService;
import mc.service.UserService;
@Controller
public class ReceptionController {
private HttpSession session;
	
	@Autowired
    private UserService userService;
	@Autowired
    private DoctorService doctorService;
	
	@RequestMapping(value = "receptionHome", method = RequestMethod.GET)
    public String login(Model model, String username,String password, HttpServletRequest request) {
		session = request.getSession();
		
			return "/reception/receptionHome";
		}
    }
	
	
