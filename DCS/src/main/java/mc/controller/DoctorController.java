package mc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mc.model.Patient;
import mc.model.User;
import mc.service.PatientService;
import mc.service.UserService;

@Controller
public class DoctorController {
	
	@Autowired
    private PatientService patientService;
	@Autowired
    private UserService userService;
	
	//TODO get data from web page 
	@RequestMapping(value = "/regPatient")
    public String reg(Model model) {
		//check if username exists 
		String userName = "testt";//get from web
		User existingUser = userService.findByUserName(userName);
		if(null!=existingUser) {
			model.addAttribute("error", "invilid user name");
			return "signUpPage";//TODO
		}
		User user = new User();
		user.setEmail("lingsun@mum.edu");
		user.setFirstName("sun");
		user.setLastName("sun");
		user.setMiddleName("");
		user.setPwd("123456");
		user.setRegDate(new Date());
		user.setUserName("sunl");
		
		Patient patient = new Patient();
		patient.setInsuranceNum("MUM1234343");
		
		patientService.regPatient(user, patient);
		return "welcome";
    }

}
