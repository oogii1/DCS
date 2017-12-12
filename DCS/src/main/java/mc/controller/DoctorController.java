package mc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.form.ReaForm;
import mc.model.Appointment;
import mc.model.Patient;
import mc.model.Treatment;
import mc.model.User;
import mc.model.Doctor;
import mc.service.AppointmentService;
import mc.service.PatientService;
import mc.service.SettingService;
import mc.service.TreatmentService;
import mc.service.UserService;

@Controller
public class DoctorController {
	
	@Autowired
    private TreatmentService trService;
	@Autowired
    private UserService userService;
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
    private SettingService sService;
	
	//TODO get data from web page 
	@RequestMapping(value = "/regDoctor")
    public String reg(Model model) {
		//check if username exists 
		String userName = "testt";//get from web
		User existingUser = userService.findByUserName(userName);
		if(null!=existingUser) {
			model.addAttribute("error", "invilid user name");
			return "signUpPage";//TODO
		}
		/*User user = new User();
		user.setEmail("lingsun@mum.edu");
		user.setFirstName("sun");
		user.setLastName("sun");
		user.setMiddleName("");
		user.setPwd("123456");
		user.setRegDate(new Date());
		user.setUserName("sunl");
		
		Patient patient = new Patient();
		patient.setInsuranceNum("TEST123");
		
		patientService.regPatient(user, patient);*/
		List<Appointment> appointments = appointmentService.listByDate();
		model.addAttribute("appointments", appointments);
		return "welcome";
    }
	@RequestMapping(value = "doctorHome", method = RequestMethod.GET)
    public String login(Model model, String username,String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Appointment> appointments = appointmentService.listByDateGreaterThan();
		model.addAttribute("appointments", appointments);
		model.addAttribute("teeth",sService.listByType("TOOTH_NUM"));
			return "/doctor/homed";
		}
    
	@RequestMapping(value = "saveTreatment", method = RequestMethod.POST)
	public String saveTreatment(Model model, HttpServletRequest request, @ModelAttribute Treatment trForm) {
		HttpSession session = request.getSession();
		if(trForm!=null) {
			
			Doctor doctor = (Doctor)session.getAttribute("doctor");
			Patient patient = (Patient)session.getAttribute("patient");
			trForm.setDoctor(doctor);
			trForm.setPatient(patient);
			trService.save(trForm);
		}
		/*HttpSession session = request.getSession();
		List<Appointment> appointments = appointmentService.listByDateGreaterThan();
		model.addAttribute("appointments", appointments);
		model.addAttribute("teeth",sService.listByType("TOOTH_NUM"));*/
		return "redirect:doctorHome";
		}
	}


