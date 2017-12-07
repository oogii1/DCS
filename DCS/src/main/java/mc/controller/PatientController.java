package mc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.form.RegForm;
import mc.model.Patient;
import mc.model.Setting;
import mc.model.User;
import mc.service.PatientService;
import mc.service.SettingService;
import mc.service.UserService;

@Controller
public class PatientController {
	
	@Autowired
    private PatientService patientService;
	@Autowired
    private UserService userService;
	@Autowired
    private SettingService settingService;
	
	@RequestMapping(value = "/regPatient",method = RequestMethod.POST)
    public String reg(Model model,@ModelAttribute RegForm regForm) {
		//1. check if username exists 
		String userName = regForm.getUserName();//get from web
		User existingUser = userService.findByUserName(userName);
		if(null!=existingUser) {
			model.addAttribute("error", "invilid user name");
			return "regPage";
		}
		Setting roleType = settingService.findByTypeAndKey("ROLE_TYPE", "Patient");
		if(roleType==null) {
			model.addAttribute("error", "Sorry Not Ready Yet");
			return "regPage";
		}
		User user = new User();
		user.setEmail(regForm.getEmail());
		user.setFirstName(regForm.getFisrtName());
		user.setLastName(regForm.getLastName());
		user.setMiddleName(regForm.getMiddleName());
		user.setPwd(regForm.getPassword());
		user.setRegDate(new Date());
		user.setUserName(regForm.getUserName());
		user.setSetting(roleType);
		
		Patient patient = new Patient();
		patient.setInsuranceNum(regForm.getInsuranceNum());
		
		patientService.regPatient(user, patient);
		
		//set session scope TODO 
		return "welcome";
    }

}
