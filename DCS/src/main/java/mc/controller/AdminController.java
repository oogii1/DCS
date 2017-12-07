package mc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mc.model.Certificate;
import mc.model.Doctor;
import mc.model.Receptionist;
import mc.model.User;
import mc.service.DoctorService;
import mc.service.SettingService;
import mc.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
    private DoctorService doctorService;
	@Autowired
    private UserService userService;
	@Autowired
    private SettingService settingService;
	
	
	//TODO add receptionlist or doctor
	@RequestMapping(value = "/addStaff")
    public String reg(Model model) {
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
		
		//if receptionist,initial certification info
		Receptionist receptionist = new Receptionist();
		receptionist.setEmployeeNo("SYS AUTO GENERATE");
		
		//doctor,initial certification info
		List<Certificate> certs = new ArrayList<Certificate>();
		for (int i =0;i<1;i++) {
			Certificate certificate = new Certificate();
			certificate.setCertNo("certNo");
			certificate.setName("certName");
			certificate.setStartDate(new Date());
			certificate.setEndDate(new Date());
			//TODO get setting id from page 
			certificate.setSetting(settingService.findById(22222));
			
		}
		Doctor doctor = new Doctor();
		doctor.setStartWorking(new Date());
		doctor.setWorkingYears("3 years");
		doctor.setAbout("DDDDDDDDDD");
		
		doctorService.regDoctor(user, doctor, certs);
		return "welcome";
    }

}
